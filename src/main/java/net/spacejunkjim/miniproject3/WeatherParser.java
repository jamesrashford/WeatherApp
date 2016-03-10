package net.spacejunkjim.miniproject3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
 * ICP 2052 - Mini Project 3: XML
 * Class: WeatherParser
 * Date: 09/03/2016
 * Purpose: Parses the BBC RSS Weather feed XML.
 * 
 * @author James Ashford, Dorian Dressler
 */
public class WeatherParser {

    private boolean inavlidCode;
    private String title;
    private String desciption;

    /**
     * Constructor
     * @param addressHTTP the address of the feed
     */
    public WeatherParser(String addressHTTP) {
        // Set invalid code to null
        inavlidCode = false;

        // Create a document builder using factory
        DocumentBuilder builder = getDocumentBuilder();

        // Get the URL of the BBC Weather RSS feed using HTTP address
        URL url = getURL(addressHTTP);

        Document doc = null;
        try {
            // Create a document from parsed url stream
            InputStream is = url.openStream();
            doc = builder.parse(is);
        } catch (SAXException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            if (ex.getClass() == FileNotFoundException.class) {
                System.out.println("404 I don't exist");
                inavlidCode = true;
            }
        }

        // Start parsing with error handling
        title = parseTitle(doc);
        desciption = parseDesciption(doc);
    }

    /**
     * Parses XML document
     * @param locationCode Location ID supplied by caller
     */
    public WeatherParser(int locationCode) {
        // Create a document builder using factory
        DocumentBuilder builder = getDocumentBuilder();

        // Get the URL of the BBC Weather RSS feed using location code
        URL url = getURL(locationCode);

        Document doc = null;
        try {
            // Create a document from parsed url stream
            doc = builder.parse(url.openStream());
        } catch (SAXException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            if (ex.getClass() == FileNotFoundException.class) {
                System.out.println("404 I don't exist");
                inavlidCode = true;
            }
        }

        // Start parsing with error handling
        title = parseTitle(doc);
        desciption = parseDesciption(doc);
    }

    /**
     * Getter method for XML Title
     * @return parsed XML Title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Getter method for XML Description
     * @return parsed XML Description
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * 
     * @return 
     */
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

    /**
     * 
     * @param address
     * @return 
     */
    private URL getURL(String address) {
        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return url;
    }

    /**
     * 
     * @param locationCode
     * @return 
     */
    private URL getURL(int locationCode) {
        String code = String.valueOf(locationCode);
        URL url = null;
        try {
            url = new URL("http://open.live.bbc.co.uk/weather/feeds/en/" + code + "/observations.rss");
        } catch (MalformedURLException ex) {
            Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }
    
    /**
     * 
     * @param doc
     * @return 
     */
    private String parseTitle(Document doc) {
        if (!inavlidCode) {
            // Create new XPath using factory
            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath path = xpfactory.newXPath();

            // Get the first title element of the RSS feed and output
            String output = "Location Data Not Found!";
            try {
                output = path.evaluate("/rss/channel/item/title", doc);
            } catch (XPathExpressionException ex) {
                Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Return the title
            return output;
        } else {
            return "ERROR";
        }
    }
    
    /**
     * 
     * @param doc
     * @return 
     */
    private String parseDesciption(Document doc) {
        if (!inavlidCode) {
            // Create new XPath using factory
            XPathFactory xpfactory = XPathFactory.newInstance();
            XPath path = xpfactory.newXPath();

            // Get the first title element of the RSS feed and output
            String output = "Location Data Not Found!";
            try {
                output = path.evaluate("/rss/channel/item/description", doc);
            } catch (XPathExpressionException ex) {
                Logger.getLogger(WeatherParser.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Return the title
            return output;
        } else {
            return "ERROR";
        }
    }

}
