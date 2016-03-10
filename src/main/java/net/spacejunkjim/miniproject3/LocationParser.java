package net.spacejunkjim.miniproject3;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
 * Class: LocationParser
 * Date: 09/03/2016
 * Purpose: Class parses results from BBC RSS Weather feed for available locations.
 * Used in dropdown menu
 * 
 * @author James Ashford, Dorian Dressler
 */
public class LocationParser {
    private static final String GEONAMES_USERNAME = "spacejunkjim";
    private ArrayList<Location> output;
    
    /**
     * 
     * @param location 
     */
    public LocationParser(String location) {
        // Create a document builder using factory
        DocumentBuilder builder = getDocumentBuilder();
        
        // Get the URL of the BBC Weather RSS feed using location code
        URL url = getURL(location);
        
        Document doc = null;
        try {
            // Create a document from parsed url stream
            doc = builder.parse(url.openStream());
        } catch (SAXException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Start parsing
        output = parse(doc);
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Location> getOutput() {
        return output;
    }
    
    private DocumentBuilder getDocumentBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return builder;
    }
    
    /**
     * 
     * @param location
     * @return 
     */
    private URL getURL(String location) {
        URL url = null;
        try {
            String query = URLEncoder.encode(location, StandardCharsets.UTF_8.toString());
            url = new URL("http://api.geonames.org/search?q=" + query + "&lang=en&username=" + GEONAMES_USERNAME);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return url;
    }
    /**
     * 
     * @param doc
     * @return 
     */
    private ArrayList<Location> parse(Document doc) {
        // Create new XPath using factory
        XPathFactory xpfactory = XPathFactory.newInstance();
        XPath path = xpfactory.newXPath();
        
        ArrayList<Location> output = new ArrayList<Location>();
        
        try {
            int count = Integer.parseInt(path.evaluate("count(/geonames/geoname)", doc));
            
            for (int i = 1; i <= count; i++) {
                String city = path.evaluate("/geonames/geoname[" + i + "]/toponymName", doc);
                String country = path.evaluate("/geonames/geoname[" + i + "]/countryName", doc);
                int geonameId = Integer.parseInt(path.evaluate("/geonames/geoname[" + i + "]/geonameId", doc));
                
                output.add(new Location(city, country, geonameId));
            }
            
        } catch (XPathExpressionException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Return the title
        return output;
    }
}
