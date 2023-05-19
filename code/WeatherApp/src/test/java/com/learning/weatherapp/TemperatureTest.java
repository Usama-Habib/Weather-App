package com.learning.weatherapp;

import com.learning.weatherapp.service.Temperature;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TemperatureTest {
    Temperature temperatureService = new Temperature();

    @Test
    public void testTemperature(){

        // LETs TEST FOR BOUNDARY VALUE.

        // INPUT TEMPERATURE CAN'T EXCEED 60 OR CAN'T BE BELOW -25
        Assertions.assertEquals("temperature_invalid",temperatureService.find_temperature("Karachi","morning",80));

        // INPUT MONTH CAN'T EXCEED 12 OR CAN'T BE BELOW 1
        Assertions.assertEquals("temperature_invalid",temperatureService.find_temperature("Karachi","morning",-30));

        // WHITE BOX TESTING
        /*
         * ONE CAN TEST THE QUALITY OR INTERNAL DESIGN OF CODE.
         * LET'S SAY WE PERFORM WHITE BOX TEST TO ENSURE SYSTEM RETURN THE CORRECT RECORDS THAT WE HAVE
         * FOR DEMONSTRATION PURPOSE WE WILL CHECK THE CITIES TEMPERATURE DATA SIZE IN OUR SYSTEM
         * */

        final int CITIES_TEMP_DATA_SIZE = 3;
        Assertions.assertEquals(CITIES_TEMP_DATA_SIZE, temperatureService.getCitiesTemperature().size());


    }

}
