package com.trackCalculator.trackCalc.calcLogic.calculators;

import com.trackCalculator.trackCalc.calcLogic.util.TimeConversions;
import com.trackCalculator.trackCalc.calcLogic.util.TrimHour;
import com.trackCalculator.trackCalc.serverModels.ServerTimeCalculatorData;

public class TimeCalculator {

    public static ServerTimeCalculatorData calculateTime(Float distance, int hourPace, int minutePace, float secondPace, String paceUnits){

        float totalPaceSeconds = TimeConversions.convertToSeconds(hourPace, minutePace, secondPace);



        if (paceUnits.equals("kilometers")) {
            return new ServerTimeCalculatorData(calculateTimeForKilometer(distance, totalPaceSeconds));

        } else if (paceUnits.equals("miles")) {
            return new ServerTimeCalculatorData(calculateTimeForMile(distance, totalPaceSeconds));
        } else {
            return new ServerTimeCalculatorData("Invalid Input");
            //probably will throw an exception
        }

    }

    private static String calculateTimeForMile(float miles, float totalPaceSeconds) {
        float totalSeconds = miles * totalPaceSeconds;
        int hours = (int) totalSeconds / 3600;
        int minutes = (int) ((totalSeconds % 3600) / 60);
        float seconds = totalSeconds % 60;

        String formattedTime = String.format("%02d:%02d:%05.2f", hours, minutes, seconds);

        formattedTime = TrimHour.checkHourTrim(formattedTime);

        return formattedTime;
    }

    private static String calculateTimeForKilometer(float kilometers, float totalPaceSeconds) {
        float totalSeconds = kilometers * totalPaceSeconds;
        int hours = (int) totalSeconds / 3600;
        int minutes = (int) ((totalSeconds % 3600) / 60);
        float seconds = totalSeconds % 60;

        String formattedTime = String.format("%02d:%02d:%05.2f", hours, minutes, seconds);

        formattedTime = TrimHour.checkHourTrim(formattedTime);

        return formattedTime;
    }



}



