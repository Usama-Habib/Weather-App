package com.learning.weatherapp.data;

import com.learning.weatherapp.dto.SeasonDuration;

import java.util.*;

public class SeasonData {
    private Map<String, List<Map<String, SeasonDuration>>> seasons = new HashMap<>();

    public SeasonData(){


        // SEASONS IN PAKISTAN
        seasons.put("pakistan", Arrays.asList(
           new HashMap<>(){{
               put("summer",new SeasonDuration(3,1,5,31));
           }},
            new HashMap<>(){{
                put("winter", new SeasonDuration(12,1,2,28));
            }},
            new HashMap<>(){{
                put("autumn", new SeasonDuration(10,1,11,30));
            }},
            new HashMap<>(){{
                put("monsoon",new SeasonDuration(6,1,9,30));
            }}
        ));

        // SEASONS IN AUSTRALIA

        seasons.put("australia", Arrays.asList(
                new HashMap<>(){{
                    put("summer", new SeasonDuration(12,1,2,28));
                }},
                new HashMap<>(){{
                    put("winter", new SeasonDuration(3,1,5,31));
                }},
                new HashMap<>(){{
                    put("autumn", new SeasonDuration(6,1,8,28));
                }},
                new HashMap<>(){{
                    put("spring", new SeasonDuration(9,1,11,30));
                }}
        ));


        // SEASONS IN INDIA
        seasons.put("india", Arrays.asList(
                new HashMap<>(){{
                    put("summer",new SeasonDuration(3,1,5,31));
                }},
                new HashMap<>(){{
                    put("winter", new SeasonDuration(12,1,2,28));
                }},
                new HashMap<>(){{
                    put("autumn", new SeasonDuration(10,1,11,30));
                }},
                new HashMap<>(){{
                    put("monsoon",new SeasonDuration(6,1,9,30));
                }}
        ));

        // SEASONS IN United States
        seasons.put("united states", Arrays.asList(
                new HashMap<>(){{
                    put("summer", new SeasonDuration(6,1,8,31));
                }},
                new HashMap<>(){{
                    put("fall", new SeasonDuration(9,1,11,30));
                }},
                new HashMap<>(){{
                    put("winter", new SeasonDuration(12,1,2,28));
                }},
                new HashMap<>(){{
                    put("spring", new SeasonDuration(3,1,5,31));
                }}

        ));

    }

    public Map<String, List<Map<String, SeasonDuration>>> getSeasons() {
        return seasons;
    }
}
