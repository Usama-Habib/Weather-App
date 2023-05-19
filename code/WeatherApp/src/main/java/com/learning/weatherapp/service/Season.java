package com.learning.weatherapp.service;

import com.learning.weatherapp.data.SeasonData;
import com.learning.weatherapp.dto.SeasonDuration;

import java.util.List;
import java.util.Map;

/**
 * <h1>Find Season</h1>
 * The find_season program implements an application that
 * simply finds the season within a country given country's name and month
 * It returns the season name as an output.
 * <p>
 * <b>Note:</b> It only provide information about those countries, whose data is available to it.
 *
 *
 * @author  Author-Name
 * @version 1.0
 * @since   2023-05-19
 */

public class Season {

    /**
     * This method is used to find the season. It takes country name and month as an input.
     * @param country This is the first paramter to find_season method
     * @param month  This is the second parameter to find_season method
     * @return String This returns Season name of given country in given month.
     */

    //  Define a function to find the season of a given country and month
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
    public java.util.Map<String, java.util.List<java.util.Map<String, com.learning.weatherapp.dto.SeasonDuration>>> getSeasonsInfo(){
        return new SeasonData().getSeasons();
    }
}
