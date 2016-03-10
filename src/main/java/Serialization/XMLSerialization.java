package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class XMLSerialization {
    public static final String FILE_NAME = "weatherFile.xml";
    XMLInputFactory inputFactory;
    XMLOutputFactory outputFactory;
    XMLEventFactory eventFactory;
            
    public XMLSerialization(){
        inputFactory    = XMLInputFactory.newInstance();
        outputFactory  = XMLOutputFactory.newInstance();
        eventFactory    = XMLEventFactory.newInstance();
    }
    
    private void writeStream() {
        File f = new File(FILE_NAME);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void readStream() {
        File f = new File(FILE_NAME);
        FileInputStream fis;
        
        try {
            fis = new FileInputStream(f);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLSerialization.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
  }
