/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

/**
 *
 * @author Acer
 */
public class XMLSerializationTester {
    
    public static void main(String[] args){
     
        System.out.println("!!!TESTER FOR XMLSERIALIZATION!!!");
        XMLSerialization serializer = new XMLSerialization();
        
        serializer.addSearchItems("A", true, 37394);
        serializer.addSearchItems("B", false, 37644);
        serializer.addSearchItems("C", true, 37326);
        serializer.addSearchItems("D", false, 32549);
    }
}
