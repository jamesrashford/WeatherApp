package net.spacejunkjim.miniproject3;

import java.util.ArrayList;

/**
 * ICP 2052 - Mini Project 3: XML
 * Class: LocationTester
 * Date: 09/03/2016
 * Purpose: Test harness for the location class.
 * 
 * @author James Ashford, Dorian Dressler
 */
public class LoactionTester {

    public static void main(String[] args) {
        
        LocationParser parser = new LocationParser("Norwich");
        ArrayList<Location> locations = parser.getOutput();
    }
    
}
