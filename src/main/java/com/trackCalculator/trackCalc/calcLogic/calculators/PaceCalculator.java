package com.trackCalculator.trackCalc.calcLogic.calculators;


import com.trackCalculator.trackCalc.calcLogic.util.TimeConversions;
import com.trackCalculator.trackCalc.serverModels.ServerPaceCalculatorData;

import static com.trackCalculator.trackCalc.calcLogic.util.TrimHour.checkHourTrim;

public class PaceCalculator {



    public static ServerPaceCalculatorData calculateAveragePace(Float distance, int hours, int minutes, Float seconds, String distanceUnit){

        float totalSeconds = TimeConversions.convertToSeconds(hours, minutes, seconds);

        Float kilometerDistance;
        Float mileDistance;

        if(distanceUnit.equals("kilometers")){
            kilometerDistance = distance;
            mileDistance = distance * 0.621371f;
        }
        else if(distanceUnit.equals("miles")){
            mileDistance = distance;
            kilometerDistance = distance * 1.60934f;
        }
        else{
            //throw an exeception
            return new ServerPaceCalculatorData("invalid", "invalid");
        }


        String pacePerMile = calculateAveragePacePerMile(mileDistance, totalSeconds);
        String pacePerKilometer = calculateAveragePacePerKilometer(kilometerDistance, totalSeconds);

         return new ServerPaceCalculatorData(pacePerMile, pacePerKilometer);
    }


    static private String calculateAveragePacePerMile(float miles, float totalSeconds){

        int hours =  (int) totalSeconds / 3600;
        int minutes = (int) ((totalSeconds % 3600) / 60);
        float seconds = (totalSeconds % 60);

        float totalTimeInHours = (float) (hours + (minutes / 60.0) + (seconds / 3600.0));
        float pacePerHour = totalTimeInHours / miles;

        int paceMinutes = (int) ((pacePerHour - Math.floor(pacePerHour)) * 60);
        float paceSeconds = (pacePerHour * 3600) % 60;


        if(paceSeconds > 59.99){
            paceSeconds = 0;
            paceMinutes++;
        }
        if(paceMinutes > 59){
            paceMinutes = 0;
            pacePerHour++;
        }


        String formattedPace = String.format("%02d:%02d:%05.2f", (int) Math.floor(pacePerHour), paceMinutes, paceSeconds);

        //removes leading zeros if the hours are zeros
        formattedPace = checkHourTrim(formattedPace);

        return formattedPace;

    }



    static private String calculateAveragePacePerKilometer(float kilometers, float totalSeconds) {
        int hours = (int) totalSeconds / 3600;
        int minutes = (int) ((totalSeconds % 3600) / 60);
        float seconds =  (totalSeconds % 60);

        float totalTimeInHours = hours + (minutes / 60.0f) + (seconds / 3600.0f);
        float pacePerHour = totalTimeInHours / kilometers;

        int paceMinutes = (int) ((pacePerHour - Math.floor(pacePerHour)) * 60);
        float paceSeconds = (pacePerHour * 3600) % 60;


        if(paceSeconds > 59.99){
            paceSeconds = 0;
            paceMinutes++;
        }
        if(paceMinutes > 59){
            paceMinutes = 0;
            pacePerHour++;
        }

        String formattedPace = String.format("%02d:%02d:%05.2f", (int) Math.floor(pacePerHour), paceMinutes, paceSeconds);



        //removes leading zeros if the hours are zeros
        formattedPace = checkHourTrim(formattedPace);

        return formattedPace;
    }


    //removes leading zeros if the hours are zeros


}