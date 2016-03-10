package net.spacejunkjim.miniproject3;

/**
 * ICP 2052 - Mini Project 3: XML
 * Class: WeatherTester
 * Date: 09/03/2016
 * Purpose: Testing Harness, testing parser for multiple locations.
 * 
 * @author James Ashford, Dorian Dressler
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
        
    }
    
}
