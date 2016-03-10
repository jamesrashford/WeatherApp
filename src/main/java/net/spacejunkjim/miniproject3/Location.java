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
public class Location {
    private String name;
    private String country;
    private int geonameId;
    private boolean isLocationFound;

    public Location(String name, String country, int geonameId) {
        this.name = name;
        this.country = country;
        this.geonameId = geonameId;
        this.isLocationFound = false;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getGeonameId() {
        return geonameId;
    }
    
    public void setLocationFound(boolean isLocationFound){
        
        this.isLocationFound = isLocationFound;
    }
    
    public boolean isLocationFound(){
        
        return isLocationFound;
    }
    
}
