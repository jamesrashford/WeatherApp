/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spacejunkjim.miniproject3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author jamesashford
 */
public class WeatherParser {
    private String locationCode; // 2641181
    private String output;
    
    public WeatherParser(String code) {
        locationCode = code;
        
        // Create a document builder using factory
        DocumentBuilder builder = getDocumentBuilder();
        
        // Get the url of the BBC Weather RSS feed
        URL url = getURL();
        
        Document doc = null;
        try {
            // Create a document from parsed url stream
            doc = builder.parse(url.openStream());
        } catch (SAXException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Start parsing
        output = parse(doc);
    }
    
    public String getOutput() {
        return output;
    }
    
    private DocumentBuilder getDocumentBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return builder;
    }
    
    private URL getURL() {
        URL url = null;
        try {
            url = new URL("http://open.live.bbc.co.uk/weather/feeds/en/" + locationCode + "/observations.rss");
        } catch (MalformedURLException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return url;
    }
    
    private String parse(Document doc) {
        // Create new XPath using factory
        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath path = xpfactory.newXPath();
        
        // Get the first title element of the RSS feed and output
        String output = "ERROR";
        try {
            output = path.evaluate("/rss/channel/item/title", doc);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return the title
        return output;
    }
    
}
