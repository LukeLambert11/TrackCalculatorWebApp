package com.trackCalculator.trackCalc;

import com.trackCalculator.trackCalc.calcLogic.calculators.HungarianScoringCalculator;

public class Main {

    public static void main(String[] args){

        Float score = HungarianScoringCalculator.getScore("m", "Indoor", "1500", 4 *60f);
        System.out.println(score);
    }
}
