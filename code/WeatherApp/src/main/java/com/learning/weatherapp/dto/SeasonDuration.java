package com.learning.weatherapp.dto;

import java.util.Arrays;

public class SeasonDuration {
    private int arr[][] = new int[2][2];

    public SeasonDuration(int start_month, int start_month_date, int end_month, int end_month_date){
        this.arr[0][0] = start_month;
        this.arr[0][1] = start_month_date;
        this.arr[1][0] = end_month;
        this.arr[1][1] = end_month_date;
    }

    public int[][] getArr() {
        return arr;
    }

    @Override
    public String toString() {
        return "SeasonDuration{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
