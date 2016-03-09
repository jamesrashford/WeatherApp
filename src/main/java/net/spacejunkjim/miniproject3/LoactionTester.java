/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spacejunkjim.miniproject3;

import java.util.ArrayList;

/**
 *
 * @author jamesashford
 */
public class LoactionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocationParser parser = new LocationParser("Norwich");
        ArrayList<Location> locations = parser.getOutput();
    }
    
}
