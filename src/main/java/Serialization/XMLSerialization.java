package Serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * ICP 2052 - Mini Project 3: XML
 * Class: XMLSerialization
 * Date: 09/03/2016
 * Purpose: Serializes received Weather Data into a temporary XML File.
 * 
 * @author James Ashford, Dorian Dressler
 */
public class XMLSerialization implements Serializable {
    
    private File tempFile;
    private XMLStreamWriter streamWriter;
    private XMLInputFactory inputFactory;
    private XMLOutputFactory outputFactory;
    private XMLEventFactory eventFactory;
    String fileName;
    
    /**
     * Constructor for XMLSerialization.
     */
    public XMLSerialization() {
        inputFactory = XMLInputFactory.newInstance();
        outputFactory = XMLOutputFactory.newInstance();
        eventFactory = XMLEventFactory.newInstance();

        try {
            tempFile = java.io.File.createTempFile("loactionsDataTemp", ".xml");
            fileName = tempFile.getAbsolutePath();
            System.out.println(fileName);

            streamWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(tempFile), "UTF-8");

        } catch (IOException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        createSearchFile();
    }
    
    /**
     * Creates Start and End Document Tags skeleton for XML data,
     * at program start.
     */
    private void createSearchFile() {
        try {
            streamWriter.writeStartDocument();
            streamWriter.writeStartElement("weatherSearches");

            streamWriter.writeEndElement();
            streamWriter.writeEndDocument();
            streamWriter.flush();
            streamWriter.close();

        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Constructs XML document, containing date along with supplied search 
     * parameters. Appends to skeleton created in createSearchFile method.
     * @param term user's supplied search term
     * @param found boolean, indicating whether location has been found
     * @param geoNameID geoName ID of location, if found.
     */
    public void addSearchItems(String term, boolean found, int geoNameID) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(tempFile);
            Element root = doc.getDocumentElement();
            Element searchElement = doc.createElement("search");
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
           
            searchElement.setAttribute("date", dateFormat.format(date));
            
            Element termElement = doc.createElement("terms");
            termElement.appendChild(doc.createTextNode(term));
            searchElement.appendChild(termElement);
            
            Element foundElement = doc.createElement("found");
            foundElement.appendChild(doc.createTextNode(String.valueOf(found)));
            searchElement.appendChild(foundElement);

            Element geoNameElement = doc.createElement("geoNameID");
            geoNameElement.appendChild(doc.createTextNode(String.valueOf(geoNameID)));
            searchElement.appendChild(geoNameElement);
            
            root.appendChild(searchElement);
            
            TransformerFactory transFactory = TransformerFactory.newInstance();
           
            Transformer  transformer = transFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fileName);
            transformer.transform(source, result);
    }   catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
