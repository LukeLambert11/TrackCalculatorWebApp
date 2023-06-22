package com.trackCalculator.trackCalc.calcLogic.util;

public class TrimHour {

    public static String checkHourTrim(String time){
        if(time.substring(0, 2).equals("00")){
            return time = time.substring(3, time.length());
        }
        else{
            return time;
        }
    }
}
