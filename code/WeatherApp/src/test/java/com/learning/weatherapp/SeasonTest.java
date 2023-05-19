package com.learning.weatherapp;

import com.learning.weatherapp.service.Season;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SeasonTest {

    Season seasonService = new Season();

    @Test
    public void testSeason(){

        /*
        * BOUNDARY VALUE ANALYSIS
        * */

        // LETs TEST FOR BOUNDARY VALUE.

        // INPUT MONTH CAN'T EXCEED 12 OR CAN'T BE BELOW 1
        Assertions.assertEquals("month_invalid",seasonService.find_season("Pakistan",14));

        // INPUT MONTH CAN'T EXCEED 12 OR CAN'T BE BELOW 1
        Assertions.assertEquals("month_invalid",seasonService.find_season("Pakistan",0));


        // WHITE BOX TESTING
        /*
        * ONE CAN TEST THE QUALITY OR INTERNAL DESIGN OF CODE.
        * LET'S SAY WE PERFORM WHITE BOX TEST TO ENSURE SYSTEM RETURN THE CORRECT RECORDS THAT WE HAVE
        * FOR DEMONSTRATION PURPOSE WE WILL CHECK THE SEASON DATA SIZE IN OUR SYSTEM
        * */

        final int SEASONS_DATA_SIZE = 4;

        Assertions.assertEquals(SEASONS_DATA_SIZE, seasonService.getSeasonsInfo().size());


    }
}
