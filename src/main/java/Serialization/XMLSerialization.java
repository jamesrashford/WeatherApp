package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.URL;
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
import javax.xml.stream.XMLStreamReader;
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
    public void writeStream() {
        /*
        URL url = getClass().getResource("data/weatherfile.xml");
        File f = new File(url.getPath());
        try {
            FileOutputStream fos = new FileOutputStream(f);
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        StringWriter writer = new StringWriter();

        try {
            File tempFile = java.io.File.createTempFile("loactionsDataTemp", ".xml");
            String fileName = tempFile.getAbsolutePath();
            System.out.println(fileName);

            XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(tempFile), "UTF-8");

            streamWriter.writeStartDocument();
            streamWriter.writeStartElement("weatherSearches");
            streamWriter.writeStartElement("search");
            streamWriter.writeAttribute("date", "Thursday");

            streamWriter.writeStartElement("term");
            streamWriter.writeCharacters("Entered search term...");
            streamWriter.writeEndElement();

            streamWriter.writeStartElement("found");
            streamWriter.writeCharacters("true/false");
            streamWriter.writeEndElement();

            streamWriter.writeStartElement("geoNameID");
            streamWriter.writeCharacters("filled in if found");
            streamWriter.writeEndElement();

            streamWriter.writeEndElement();
            streamWriter.writeEndDocument();
            streamWriter.flush();
            streamWriter.close();

//            writer.close();
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        String xmlString = writer.getBuffer().toString();
        
        try {
            
        } catch (IOException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(xmlString);
        
        PrintWriter printWriter;
        try {
            
            
            printWriter = new PrintWriter(f);
            printWriter.write(xmlString);
            printWriter.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }

    public void readStream() {
        URL url = getClass().getResource("data/weatherfile.xml");
        File f = new File(url.getPath());
        FileInputStream fis;

        try {
            fis = new FileInputStream(f);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fis);
            while (reader.hasNext()) {

                System.out.println(reader.next());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
