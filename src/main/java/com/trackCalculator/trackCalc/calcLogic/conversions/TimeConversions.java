package com.trackCalculator.trackCalc.calcLogic.conversions;

public class TimeConversions {

    public static Float convertToSeconds(int hours, int minutes, Float seconds){
        return hours * 60.f * 60.f + minutes * 60.f + seconds;
    }

    public static String convertToFullTime(float seconds){

        //one hour is 3600 seconds

        StringBuilder string = new StringBuilder();

        int hours = (int) (seconds / 3600);
        int minutes = (int) ((seconds % 3600) / 60);
        int remainingSeconds = (int) (seconds % 60);

        string.append(Integer.toString(hours));
        string.append(":");
        string.append(Integer.toString(minutes));
        string.append(":");
        string.append(Integer.toString(remainingSeconds));

        return string.toString();

    }


}
