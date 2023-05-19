package com.learning.weatherapp.service;

import com.learning.weatherapp.data.SeasonData;
import com.learning.weatherapp.dto.SeasonDuration;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Season {

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

    // Load Seasons Data
    public java.util.Map<String, java.util.List<java.util.Map<String, com.learning.weatherapp.dto.SeasonDuration>>> getSeasonsInfo(){
        return new SeasonData().getSeasons();
    }
}
