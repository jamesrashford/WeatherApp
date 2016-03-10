/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spacejunkjim.miniproject3;

/**
 *
 * @author jamesashford
 */
public class WeatherTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Weather Observations");
        System.out.println("--------------------");
        System.out.println();
        System.out.println("Norwich, Norfolk, UK");
        testOne();
        System.out.println();
        System.out.println("Bangor, North Wales");
        testTwo();
        System.out.println();
    }
    
    private static void testOne() {
        // Code for Norwich, Norfolk, UK
        int code = 2641181;
        WeatherParser parser = new WeatherParser(code);
        
        // Print output
        //String output = parser.getOutput();
        //System.out.println(output);
    }
    
    private static void testTwo() {
        // HTTP address for Bangor, North Wales
        String addressHTTP = "http://open.live.bbc.co.uk/weather/feeds/en/2656397/observations.rss";
        WeatherParser parser = new WeatherParser(addressHTTP);
        
        // Print output
        //String output = parser.getOutput();
        //System.out.println(output);
    }
    
}
