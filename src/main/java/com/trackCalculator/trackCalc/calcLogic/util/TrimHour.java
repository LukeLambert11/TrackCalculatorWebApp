package com.trackCalculator.trackCalc.calcLogic.util;

public class TrimHour {

    public static String checkHourTrim(String time){
        if(time.startsWith("00")){
            return time.substring(3);
        }
        else{
            return time;
        }
    }
}
