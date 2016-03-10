package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author James Ashford, Dorian Dressler
 */
public class XMLSerialization implements Serializable {

    public static final String FILE_NAME = "data/weatherfile.xml";
    XMLInputFactory inputFactory;
    XMLOutputFactory outputFactory;
    XMLEventFactory eventFactory;

    public XMLSerialization() {
        inputFactory = XMLInputFactory.newInstance();
        outputFactory = XMLOutputFactory.newInstance();
        eventFactory = XMLEventFactory.newInstance();
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
