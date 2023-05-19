package com.learning.weatherapp.service;

import com.learning.weatherapp.data.CitiesData;

import java.util.List;
import java.util.Map;

/**
 * <h1>Find Temperature</h1>
 * The find_temperature program implements an application that
 * simply finds the temperature difference compare to the average temperature
 * of the given city.
 * It returns how much is the difference compare to given temperature value as an output.
 * <p>
 * <b>Note:</b> It only provide information about those cities, whose data is available to it.
 *
 *
 * @author  Author-Name
 * @version 1.0
 * @since   2023-05-19
 */
public class Temperature {

    /**
     * This method is used to find the temperature. It takes city name and time of the day (i.e. Morning,Evening)
     * and temperature value as an input.
     * @param city This is the first paramter to find_temperature method
     * @param time_of_day  This is the second parameter to find_temperature method
     * @param temperature This is the third parameter to find_temperature method
     * @return String This returns String value represent the difference in temperature compare to the input temp of a city.
     */
    // Finding temperature difference of a city
    public String find_temperature(String city, String time_of_day, int temperature){
        Map<String, List<Map<String, Integer>>> citiesTemperature = getCitiesTemperature();
        String message = "";
        // check if city exists
        if(!citiesTemperature.containsKey(city.replace("_"," ").toLowerCase())){
            return "city_invalid";
        }
        if(temperature > 60 || temperature < -20){
            return "temperature_invalid";
        }

        int average_temp = 0;
        List<Map<String, Integer>> daytimeList = citiesTemperature.get(city.replace("_", " ").toLowerCase());
        for (int i = 0; i < daytimeList.size(); i++) {
            if(daytimeList.get(i).containsKey(time_of_day.toLowerCase())){
                average_temp = daytimeList.get(i).values().iterator().next();
            }
        }

        int diff = temperature - average_temp;

        if(diff > 5) {
            message = "Temperature is more than 5°C above average.";
        } else if(diff < -5) {
            message = "Temperature is more than 5°C below average.";
        } if (diff > 0) {
            return  "Above average " + message;
        } else if (diff < 0) {
            return  "Below average " + message;
        } else {
            return "Equal to average";
        }
    }

    public int findCityTempAt(String city, String time_of_day){
        Map<String, List<Map<String, Integer>>> citiesTemperature = getCitiesTemperature();
        int average_temp = 0;
        List<Map<String, Integer>> daytimeList = citiesTemperature.get(city.replace("_", " ").toLowerCase());
        for (int i = 0; i < daytimeList.size(); i++) {
            if(daytimeList.get(i).containsKey(time_of_day.toLowerCase())){
                average_temp = daytimeList.get(i).values().iterator().next();
            }
        }
        return average_temp;
    }

    // Load Cities Temperature Data
    public java.util.Map<String, java.util.List<java.util.Map<String, Integer>>> getCitiesTemperature(){
        return new CitiesData().getCities();
    }
}
