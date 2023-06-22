package com.trackCalculator.trackCalc;

import com.trackCalculator.trackCalc.calcLogic.calculators.EquivalentPerformanceCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.HungarianScoringCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.TimeCalculator;
import com.trackCalculator.trackCalc.clientModels.ClientEquivalentPerformanceCalculatorData;

public class Main {

    public static void main(String[] args){


       /* Float score = HungarianScoringCalculator.getScore("m", "Indoor", "1500", 4 *60f);
        System.out.println(score);

        String time = TimeCalculator.calculateTime(10f, 0, 6, 0f, "kilometers");
        System.out.println(time);*/


        ClientEquivalentPerformanceCalculatorData data = new
                ClientEquivalentPerformanceCalculatorData("men", "Outdoor",
                "1500", 3f * 60f + 35.f, "men",
                "Outdoor", "800");

        EquivalentPerformanceCalculator.getEquivalentPerformance(data);


    }
}
