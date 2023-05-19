package com.learning.weatherapp.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitiesData {
    private Map<String, List<Map<String,Integer>>> cities = new HashMap<>();

    public CitiesData(){
        cities.put("london",
                Arrays.asList(
                        new HashMap<String,Integer>(){{ put("morning",12); }},
                        new HashMap<String,Integer>(){{ put("evening",17); }}
                ));

        cities.put("new york",
                Arrays.asList(
                        new HashMap<String,Integer>(){{ put("morning",10); }},
                        new HashMap<String,Integer>(){{ put("evening",15); }}
                ));

        cities.put("karachi",
                Arrays.asList(
                        new HashMap<String,Integer>(){{ put("morning",25); }},
                        new HashMap<String,Integer>(){{ put("evening",32); }}
                ));

    }

    public Map<String, List<Map<String, Integer>>> getCities() {
        return cities;
    }
}
