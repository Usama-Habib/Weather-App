package com.learning.weatherapp;

import com.learning.weatherapp.data.CitiesData;
import com.learning.weatherapp.data.SeasonData;
import com.learning.weatherapp.dto.SeasonDuration;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppRunner {
    public static void main(String[] args) {

        AppRunner app = new AppRunner();

        // FIND SEASON OF A GIVEN COUNTRY IN A GIVEN MONTH
        System.out.println("Program will help you find Country's Season");
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter country name: ");
        String country = scanner.next();

        System.out.print("Enter month number (i.e. January=1 and December=12): ");
        int month = scanner.nextInt();

        String result = app.find_season(country,month);
        if(result.equals("month_invalid") || result.equals("country_invalid")){
            System.out.println("Oops! invalid input. Either country or month is wrong! Try next time");
        }else{
            System.out.println("Season will be: " + result.toUpperCase());
        }

        System.out.println("\n\n");

        // FIND A DIFFERENCE TO AN AVERAGE TEMPERATURE OF CITY
        System.out.println("Program will help you find City's temperature");

        System.out.print("Enter city name: ");
        String city = scanner.next();

        System.out.print("Enter temperature value (i.e. Must be between -20 and 60 degree centigrade): ");
        int temperature = scanner.nextInt();

        System.out.print("Enter time_of_day (i.e. morning or evening): ");
        String dayTime = scanner.next();

        if(!dayTime.equalsIgnoreCase("morning") && !dayTime.equalsIgnoreCase("evening")){
            System.out.println("Invalid daytime. Choose between morning and evening only");
        }

        String result2 = app.find_temperature(city,dayTime,temperature);
        if(result2.equals("city_invalid") || result2.equals("temperature_invalid")){
            System.out.println("Oops! invalid input. Either city or temperature is wrong! Try next time");
        }else{
            System.out.println("Temperature is: " + result2);
        }


    }

    // 1. SEASON

    public String find_season(String country, int month){

        Map<String, List<Map<String, SeasonDuration>>> seasonsInfo = getSeasonsInfo();

        if(month > 12 || month < 1)
            return "month_invalid";
        if(!seasonsInfo.containsKey(country.toLowerCase()))
            return "country_invalid";
        List<Map<String, SeasonDuration>> seasonMap = seasonsInfo.get(country.toLowerCase());
        for (int i = 0; i < seasonMap.size(); i++) {

            // CHECK
            Map<String, SeasonDuration> stringSeasonDurationMap = seasonMap.get(i);
            Map.Entry<String, SeasonDuration> next = stringSeasonDurationMap.entrySet().iterator().next();
            int start_month = next.getValue().getArr()[0][0];
            int end_month = next.getValue().getArr()[1][0];
            if(start_month < end_month){
                if(month >= start_month && month <= end_month){
                    return next.getKey();
                }
            }else{
                if(month >= start_month || month <= end_month){
                    return next.getKey();
                }
            }
        }
        return "invalid";
    }


    /**
     * This is the helper method which load countriesSeasons data.
     * @return Map<String,List<Map<String, SeasonDuration>
     */
    // Load Seasons Data
    private java.util.Map<String, java.util.List<java.util.Map<String, com.learning.weatherapp.dto.SeasonDuration>>> getSeasonsInfo(){
        return new SeasonData().getSeasons();
    }
    // 2. TEMPERATURE

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

    // Load Cities Temperature Data
    private java.util.Map<String, java.util.List<java.util.Map<String, Integer>>> getCitiesTemperature(){
        return new CitiesData().getCities();
    }

}
