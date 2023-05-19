package com.learning.weatherapp.service;

import com.learning.weatherapp.data.CitiesData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Temperature {

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
