package com.trackCalculator.trackCalc.calcLogic.util;

public class TimeConversions {

    public static Float convertToSeconds(int hours, int minutes, Float seconds){
        return hours * 60.f * 60.f + minutes * 60.f + seconds;
    }

    public static String convertToFullTime(float seconds){

        //one hour is 3600 seconds

        StringBuilder string = new StringBuilder();

        int hours = (int) (seconds / 3600);
        int minutes = (int) ((seconds % 3600) / 60);
        float remainingSeconds =  (seconds % 60);

        string.append(String.format("%02d", hours));
        string.append(":");
        string.append(String.format("%02d", minutes));
        string.append(":");
        string.append(String.format("%.2f", remainingSeconds));

        return TrimHour.checkHourTrim(string.toString());

    }


}
