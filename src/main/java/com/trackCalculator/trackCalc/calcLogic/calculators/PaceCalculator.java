package com.trackCalculator.trackCalc.calcLogic.calculators;

import com.trackCalculator.trackCalc.calcLogic.conversions.TimeConversions;

public class PaceCalculator {

    public String calculateAveragePace(Float distance, int hours, int minutes,  Float seconds, String distanceUnit){

        Float totalSeconds = TimeConversions.convertToSeconds(hours, minutes, seconds);


        if(distanceUnit.equals("kilometers")){
            distance = distance * 0.62137119f;
        }

        return calculateAveragePacePerMile(distance, seconds);

    }


    static private String calculateAveragePacePerMile(float miles, float totalSeconds){

        int hours =  (int) totalSeconds / 3600;
        int minutes = (int) ((totalSeconds % 3600) / 60);
        int seconds = (int) (totalSeconds % 60);

        float totalTimeInHours = (float) (hours + (minutes / 60.0) + (seconds / 3600.0));
        float pacePerHour = totalTimeInHours / miles;

        int paceMinutes = (int) ((pacePerHour - Math.floor(pacePerHour)) * 60);
        float paceSeconds = (pacePerHour * 3600) % 60;

        String formattedPace = String.format("%02d:%02d:%02f", (int) Math.floor(pacePerHour), paceMinutes, paceSeconds);

        return formattedPace;


    }

}
