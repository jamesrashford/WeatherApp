package net.spacejunkjim.miniproject3;

import java.util.ArrayList;

/**
 * ICP 2052 - Mini Project 3: XML
 * Class: Weather
 * Date: 09/03/2016
 * Purpose: Class creates Weather object.
 * Receives raw data, parses it and returns it to callers.
 * 
 * @author James Ashford, Dorian Dressler (eeu436)
 */
public class Weather {
    
    private ArrayList<String> weatherData;
    private final String ERROR_FLAG = "ERROR";
    private boolean locationFound = true;
    
    
    /**
     * Constructor for Weather Class.
     * @param weather a string object containing raw weather data.
     */
    public Weather(String weather) {
            
        splitWeatherString(weather);
    }
    
    /**
     * Splits the String with weather information into substrings.
     * Stores these in an ArrayList for retrieval by getter methods.
     * @param weather text with weather information
     */
    private void splitWeatherString(String weather) {
        //String[] weatherData = new String[7]; //= weather.split(weather);
        
        weatherData = new ArrayList<>();
        int i = 0; //counter
        for(String s  : weather.split(":|,")){
            
            //Words to be ignored.
            if(s.contains("Temperature") || s.contains("Wind Direction") 
                    || s.contains("Wind Speed") || s.contains("Humidity") 
                    || s.contains("Pressure") || s.contains("Visibility")){
                
            }else{
                weatherData.add(i, s); //adding parsed Weather data to arraylist
                i++;
            }
        }
    }
    
    /**
     * Method retrieves temperature from array list.
     * @return temperature
     */
    public String getTemperature(){
        
        return weatherData.get(0);
    }
    
    /**
     * Method retrieves wind direction from array list.
     * @return wind direction
     */
    public String getWindDirection(){
        
        return weatherData.get(1);
    }
    
    /**
     * Method retrieves wind speed from array list.
     * @return wind speed
     */
    public String getWindSpeed(){
        
        return weatherData.get(2);
    }
    
    /**
     * Method retrieves humidity from array list.
     * @return humidity
     */
    public String getHumidity(){
        
        return weatherData.get(3);
    }
    
    /**
     * Method retrieves pressure from array list.
     * @return Pressure
     */
    public String getPressure(){
        String pressure = weatherData.get(4);
        pressure += (weatherData.get(5)); //could split that into a tendency method
        return pressure;
    }
    
    /**
     * Method retrieves visibility from array list.
     * @return the visibility
     */
    public String getVisibility(){
        
        return weatherData.get(6);
    }
}
