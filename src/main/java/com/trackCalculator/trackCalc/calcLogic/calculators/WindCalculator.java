package com.trackCalculator.trackCalc.calcLogic.calculators;


//https://www.tandfonline.com/doi/full/10.1080/17461391.2018.1480062

/*
ranges: 100 m; 9–20, 200 m; 19–40, long jump; 3–10 m, triple jump; 7–19 and 110 m hurdles; 12–25s.
use with caution outside -2.0 - 2.0 m/s wind
 */

import java.util.HashMap;
import java.util.function.Function;

public final class WindCalculator {


    static private final HashMap<String, WindConstant> constantHashMap = new HashMap<>();


    static{
        initializeHashMap();
    }

    private WindCalculator(){
    }



    public static String getConvertedPerformance(String event, float performance, float wind){
        return Float.toString(performance + constantHashMap.get(event).windDifference.apply(wind));
    }


    private static void initializeHashMap(){
        constantHashMap.put("100", new WindConstant(.071f, -.0042f));
        constantHashMap.put("200", new WindConstant(.09f, -.01f));
        constantHashMap.put("100H", new WindConstant(.093f, -.01f));
        constantHashMap.put("110H", new WindConstant(.093f, -.01f));
        constantHashMap.put("Long Jump", new WindConstant(.032f, -.012f));
        constantHashMap.put("Triple Jump", new WindConstant(.069f, -.009f));
    }





    private static class WindConstant{

        private final Function<Float, Float> windDifference;

        WindConstant(Float a, Float b){
            windDifference = (x) -> a * x + b * (float) Math.pow(x, 2);
        }


    }

}
