package com.trackCalculator.trackCalc.calcLogic.calculators;


import com.trackCalculator.trackCalc.calcLogic.util.TimeConversions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.Function;

public final class HungarianScoringCalculator {


    static{
        constantsHashMap = new HashMap<>();
        prepareMap();
    }


    //where all the constants are stored
    private static final HashMap<String, Constants> constantsHashMap;

    private HungarianScoringCalculator() {}

    //for field events
    public static Float getScore(String gender, String location, String event, Float performance){

        String formattedEventString = getFormattedEventString(gender, event, location);
        return constantsHashMap.get(formattedEventString).getScoreFunc.apply(performance);
    }

    //for timed events
    public static Float getScore(String gender, String location, String event, Integer hours, Integer minutes, Float seconds){

        float totalSeconds = TimeConversions.convertToSeconds(hours, minutes, seconds);

        String formattedEventString = getFormattedEventString(gender, event, location);
        return constantsHashMap.get(formattedEventString).getScoreFunc.apply(totalSeconds);
    }


    public static String getPerformance(String gender, String location, String event, Float score){

        String formattedEventString = getFormattedEventString(gender, event, location);

        Constants constants = constantsHashMap.get(formattedEventString);

        //for field events
        if(constants.isField){
            return Float.toString(constants.getPerformanceFunc.apply(score));
        }

        //for timed events
        Float timeInSeconds = constants.getPerformanceFunc.apply(score);
        return TimeConversions.convertToFullTime(timeInSeconds);

    }



    private static String getFormattedEventString(String gender, String location, String event){

        StringBuilder string = new StringBuilder();

        if(gender.equals("men")){
            string.append("men");
        }
        else{
            string.append("women");
        }

        string.append(event);
        string.append(location);

        return string.toString();
    }


    private static void prepareMap() {

        //go through each csv and add them to the hashmap

        //womenIndoor
        String filePath = "src/main/java/com/trackCalculator/trackCalc/calcLogic/iaafScoringConstants/indoorFemale.csv";
        addCsvData(filePath, "womenIndoor");

        //womenOutdoor
        filePath = "src/main/java/com/trackCalculator/trackCalc/calcLogic/iaafScoringConstants/outdoorFemale.csv";
        addCsvData(filePath, "womenOutdoor");

        //menIndoor
        filePath = "src/main/java/com/trackCalculator/trackCalc/calcLogic/iaafScoringConstants/indoorMale.csv";
        addCsvData(filePath, "menIndoor");


        //menOutdoor
        filePath = "src/main/java/com/trackCalculator/trackCalc/calcLogic/iaafScoringConstants/outdoorMale.csv";
        addCsvData(filePath, "menOutdoor");

    }

    private static void addCsvData(String filePath, String category) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {

                boolean isField = true;

                String[] values = line.split(",");

                if(values[0].contains("TRACK") || values[0].contains("ROAD") || values[0].contains("WALK")){
                    isField = false;
                }


                String event = values[0].replace("TRACK_", "");
                event = category + event;
                float a = Float.parseFloat(values[2]);
                float b = Float.parseFloat(values[3]);
                float c = Float.parseFloat(values[4]);

                /*
                System.out.println("event: " + event);
                System.out.println("a: " + a);
                System.out.println("b: " + b);
                System.out.println("c: " + c);
                System.out.println();*/
                //System.out.println(event);
                constantsHashMap.put(event, new Constants(a, b, c, isField));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //each event combo is stored in the HashMap
    private static class Constants {
        Boolean isField;
        Function<Float, Float> getScoreFunc;
        Function<Float, Float> getPerformanceFunc;


        Constants(float a, float b, float c, Boolean isField) {
            this.isField = isField;

            //score function
            getScoreFunc = (x) -> a * (float) Math.pow((x + b), 2) + c;
            //performanceFunc (ie inverse of score)
            getPerformanceFunc = (x) -> (-1 * (float) Math.sqrt(a * (x - c)) / a - b);
        }


    }

}
