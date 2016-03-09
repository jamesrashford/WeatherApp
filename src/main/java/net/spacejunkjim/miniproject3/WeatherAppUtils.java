/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.spacejunkjim.miniproject3;

import java.io.InputStream;

/**
 *
 * @author jamesashford
 */
public class WeatherAppUtils {
    
    public static String weatherToIcon(String weather) {
        if (weather.equals(WeatherConditions.WEATHER_CLOUDY)) {
            return "";
        } else if (weather.equals(WeatherConditions.WEATHER_HEAVY_RAIN)) {
            return "";
        } else if (weather.equals(WeatherConditions.WEATHER_LIGHTNING)) {
            return "";
        } else if (weather.equals(WeatherConditions.WEATHER_LIGHT_CLOUDS)) {
            return "";
        } else if (weather.equals(WeatherConditions.WEATHER_RAIN_SHOWERS)) {
            return "";
        } else if (weather.equals(WeatherConditions.WEATHER_SNOW)) {
            return "";
        } else if (weather.equals(WeatherConditions.WEATHER_SUNNY)) {
            return "";
        } else if (weather.equals(WeatherConditions.WEATHER_WINDY)) {
            return "";
        }
        return "";
    }
    
}
