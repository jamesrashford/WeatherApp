package net.spacejunkjim.miniproject3;

/**
 * ICP 2052 - Mini Project 3: XML
 * Class: Location
 * Date: 09/03/2016
 * Purpose: Class Contains stored strings for weather conditions.
 * Is used in drop down menu of GUI. And for error GUI notifications.
 * 
 * @author James Ashford, Dorian Dressler
 */
public class Location {
    private String name;
    private String country;
    private int geonameId;
    private boolean isLocationFound;

    /**
     * 
     * @param name
     * @param country
     * @param geonameId 
     */
    public Location(String name, String country, int geonameId) {
        this.name = name;
        this.country = country;
        this.geonameId = geonameId;
        this.isLocationFound = false;
    }

    /**
     * Getter for the name of the location.
     * @return location name
     */
    public String getName() {
        return name;
    }
    
    /**
     * getter method for country.
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    
    /**
     * Getter method for the geoName ID
     * @return the geoName ID
     */
    public int getGeonameId() {
        return geonameId;
    }
    
    /**
     * Setter method for the location boolean
     * @param isLocationFound a boolean value for location
     */
    public void setLocationFound(boolean isLocationFound){
        
        this.isLocationFound = isLocationFound;
    }
    
    /**
     * Getter method for whether a location has been found.
     * @return a boolean, indicating whether location has been found.
     */
    public boolean isLocationFound(){
        
        return isLocationFound;
    }
    
}
