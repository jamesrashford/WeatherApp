/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spacejunkjim.miniproject3;

import java.util.Date;

/**
 *
 * @author jamesashford
 */

// Wednesday - 13:00 GMT: Light Cloud, 7Â°C (45Â°F)
public class Weather {
    private Date date;
    private String weatherCondition;
    private float TemperatureDegrees;
    private float TemperatureFahrenheit;
    
    public Weather(String weather) {
        init(weather);
    }
    
    public Weather(WeatherParser parser) {
        String weather = parser.getOutput();
    }
    
    private void init(String weather) {
        init(weather);
    }
    
    private void init(String weather) {
        
    }
}
