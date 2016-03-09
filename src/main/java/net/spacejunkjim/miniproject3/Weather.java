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

public class Weather {
    private Date date;
    private String weatherCondition;
    private float TemperatureDegrees;
    private float TemperatureFahrenheit;
    
    public Weather(String weather) {
        split(weather);
    }
    
    public Weather(WeatherParser parser) {
        String weather = parser.getOutput();
        split(weather);
    }
    
    private void split(String weather) {
        String[] w1 = weather.split(weather);
    }
}
