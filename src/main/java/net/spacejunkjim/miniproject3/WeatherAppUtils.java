package net.spacejunkjim.miniproject3;

/**
 * ICP 2052 - Mini Project 3: XML
 * Class: WeatherAppUtils
 * Date: 09/03/2016
 * Purpose: Class matches strings to assign appropriate weather icons.
 * 
 * @author James Ashford, Dorian Dressler
 */
public class WeatherAppUtils {
    
    /**
     * Splits the raw weather description String
     * @param weather String containing raw weather condition data.
     * @return a parsed string.
     */
    public static String getWeatherCondition(String weather) {
        String part1 = weather.split(": ")[1];
        String condition = part1.split(", ")[0];
        
        return condition;
    }
    
    /**
     * 
     * @param comparator the String to parse.
     * @return the location of the icon file.
     */
    public static String weatherToIcon(String comparator) {
        comparator = comparator.toLowerCase();
        System.out.println("WeatherAppUtils " + comparator);
        String fileLocation = "";
        
        if(comparator.contains("null")){ //test case
            fileLocation = "/simple_weather_icon_02.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_SWUNNY_DAY)){
            fileLocation = "/simple_weather_icon_01.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_PARTLY_CLOUDY)){
            fileLocation = "/simple_weather_icon_07.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_SUNNY_INTERVALS)){
            fileLocation = "/simple_weather_icon_03.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_MEDIUM_CLOUD)){
            fileLocation = "/simple_weather_icon_06.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_BLACK_LOW_LEVEL_CLOUD)){
            fileLocation = "/simple_weather_icon_06.png"; // finished
        }
        if(comparator.contains(WeatherConditions.WEATHER_LIGHT_RAIN_SHOWER_NIGHT)){
            fileLocation = "/simple_weather_icon_31.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_LIGHT_RAIN_SHOWER_DAY)){
            fileLocation = "/simple_weather_icon_11.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_DRIZZLE)){
            fileLocation = "/simple_weather_icon_21.png"; // here
        }
        if(comparator.contains(WeatherConditions.WEATHER_LIGHT_RAIN_DAY_NIGHT)){
            fileLocation = "/simple_weather_icon_21.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HEAVY_RAIN_SHOWER_NIGHT)){
            fileLocation = "/simple_weather_icon_32.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HEAVY_RAIN_SHOWER_DAY)){
            fileLocation = "/simple_weather_icon_33.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HEAVY_RAIN)){
            fileLocation = "/simple_weather_icon_23.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HEAVY_RAIN_SHOWER_NIGHT)){
            fileLocation = "/simple_weather_icon_33.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_SLEET_SHOWER_DAY)){
            fileLocation = "/simple_weather_icon_16.png";
        } 
        if(comparator.contains(WeatherConditions.WEATHER_CLOUDY_WITH_SLEET)){
            fileLocation = "/simple_weather_icon_26.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HAIL_SHOWER_NIGHT)){
            fileLocation = "/simple_weather_icon_38.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HAIL_SHOWER_DAY)){
            fileLocation = "/simple_weather_icon_19.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_CLOUDY_HAIL)){
            fileLocation = "/simple_weather_icon_28.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_LIGHT_SNOW_SHOWER_DAY)){
            fileLocation = "/simple_weather_icon_16.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_CLOUDY_LIGHT_SNOW)){
            fileLocation = "/simple_weather_icon_24.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HEAVY_SHOW_SHOWER_DAY)){
            fileLocation = "/simple_weather_icon_12.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_CLOUDY_WITH_HEAVY_SNOW)){
            fileLocation = "/simple_weather_icon_25.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_THUNDERY_SHOWER_NIGHT)){
            fileLocation = "/simple_weather_icon_37.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_THUNDERY_SHOWER_DAY)){
            fileLocation = "/simple_weather_icon_17.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_THUNDERSTORMS)){
            fileLocation = "/simple_weather_icon_27.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_CLEAR_SKY_NIGHT)){
            fileLocation = "/simple_weather_icon_02.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_SANDSTORM)){
            fileLocation = "/simple_weather_icon_01.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_MIST_DAY)){
            fileLocation = "/simple_weather_icon_10.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_FOG_DAY)){
            fileLocation = "/simple_weather_icon_10.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_FOG_NIGHT)){
            fileLocation = "/simple_weather_icon_10.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_TROPICAL_STORM)){
            fileLocation = "/simple_weather_icon_30.png";
        }
        if(comparator.contains(WeatherConditions.WEATHER_HAZY)){
            fileLocation = "/simple_weather_icon_10.png";
        }
        
        return fileLocation;
    }
    
}
