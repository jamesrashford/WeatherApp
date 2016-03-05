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
        String code = "2641181";
        WeatherParser parser = new WeatherParser(code);
        
        String output = parser.getOutput();
        System.out.println(output);
    }
    
}
