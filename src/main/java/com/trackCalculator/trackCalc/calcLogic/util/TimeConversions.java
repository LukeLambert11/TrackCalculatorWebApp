package com.trackCalculator.trackCalc.calcLogic.util;

public class TimeConversions {

    public static Float convertToSeconds(int hours, int minutes, Float seconds){
        return hours * 60.f * 60.f + minutes * 60.f + Math.min(seconds, 60.f);

    }

    public static String convertToFullTime(float seconds){

        //one hour is 3600 seconds

        StringBuilder string = new StringBuilder();

        int hours = (int) (seconds / 3600);
        int minutes = (int) ((seconds % 3600) / 60);
        int remainingSeconds = (int) (seconds % 60);  // Convert remainingSeconds to int
        int milliseconds = (int) ((seconds - Math.floor(seconds)) * 1000);  // Extract milliseconds

        if (remainingSeconds == 60) {
            remainingSeconds = 0;
            minutes++;
        }


        if (minutes == 60) {
            minutes = 0;
            hours++;
        }



        string.append(String.format("%02d", hours));
        string.append(":");
        string.append(String.format("%02d", minutes));
        string.append(":");
        string.append(String.format("%02d", remainingSeconds));
        string.append(".");
        string.append(String.format("%03d", milliseconds));

        return TrimHour.checkHourTrim(string.toString());

    }


}
