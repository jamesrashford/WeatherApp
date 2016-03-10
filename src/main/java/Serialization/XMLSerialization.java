package Serialization;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

/**
 *
 * @author James Ashford, Dorian Dressler
 */
public class XMLSerialization {
    XMLInputFactory inputFactory;
    XMLOutputFactory outputFactory;
    XMLEventFactory eventFactory;
            
    public XMLSerialization(){
        
        inputFactory    = XMLInputFactory.newInstance();
        outputFactory  = XMLOutputFactory.newInstance();
        eventFactory    = XMLEventFactory.newInstance();
    }
    private void writeStream(){
        
    }
    
    private void readStream(){
        
    }
    
  }
