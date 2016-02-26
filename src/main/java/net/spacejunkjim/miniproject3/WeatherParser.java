/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spacejunkjim.miniproject3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.w3c.dom.Document;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/**
 *
 * @author jamesashford
 */
public class WeatherParser {
    public static void main(String[] args) throws MalformedURLException, IOException, SAXException, NoSuchFieldException, URISyntaxException, ParserConfigurationException, XPathExpressionException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        URL url = new URL("http://open.live.bbc.co.uk/weather/feeds/en/2641181/observations.rss");
        
        Document doc = builder.parse(url.openStream());
        XPathFactory xpfactory = XPathFactory.newInstance();
        
        XPath path = xpfactory.newXPath();
        
        String output = path.evaluate("/rss/channel/item/title", doc);
        System.out.println(output);
    }
    
}
