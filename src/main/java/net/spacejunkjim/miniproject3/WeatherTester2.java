package net.spacejunkjim.miniproject3;

/**
 * ICP 2052 - Mini Project 3: XML
 * Class: WeatherTester2
 * Date: 09/03/2016
 * Purpose: Test harness for Weather class.
 * 
 * @author James Ashford, Dorian Dressler (eeu436)
 */
public class WeatherTester2 {
    
    public static void main(String[] args){
        
        String addressHTTP = "http://open.live.bbc.co.uk/weather/feeds/en/2656397/observations.rss";
        WeatherParser parser = new WeatherParser(addressHTTP);
        Weather weatherTester = new Weather(parser.getOutput());
        System.out.print("Testing getTemperature method:");
        System.out.println(weatherTester.getTemperature());
        System.out.print("Testing getWindDirection method:");
        System.out.println(weatherTester.getWindDirection());
        System.out.print("Testing getWindSpeed:");
        System.out.println(weatherTester.getWindSpeed());
        System.out.print("Testing getHumidity:");
        System.out.println(weatherTester.getHumidity());
        System.out.print("Testing getPressure:");
        System.out.println(weatherTester.getPressure());
        System.out.print("Testing getVisibility");
        System.out.println(weatherTester.getVisibility());
    }
    
}
