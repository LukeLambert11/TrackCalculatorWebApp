package com.trackCalculator.trackCalc;

import com.trackCalculator.trackCalc.calcLogic.calculators.EquivalentPerformanceCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.HungarianScoringCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.TimeCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.WindCalculator;
import com.trackCalculator.trackCalc.clientModels.ClientEquivalentPerformanceCalculatorData;
import com.trackCalculator.trackCalc.clientModels.ClientWindConversionData;
import com.trackCalculator.trackCalc.serverModels.ServerWindConversionData;

public class Main {

    public static void main(String[] args){


       /* Float score = HungarianScoringCalculator.getScore("m", "Indoor", "1500", 4 *60f);
        System.out.println(score);

        String time = TimeCalculator.calculateTime(10f, 0, 6, 0f, "kilometers");
        System.out.println(time);*/

/*
        ClientEquivalentPerformanceCalculatorData data = new
                ClientEquivalentPerformanceCalculatorData("men", "Outdoor",
                "HIGH_JUMP", 2.3264637f, "men",
                "Outdoor", "1MILE");

        EquivalentPerformanceCalculator.getEquivalentPerformance(data);

        ServerWindConversionData data2 = WindCalculator.getConvertedPerformance("100", 10.1f, -2f);
        System.out.println(data2.getPerformance());*/
    }
}
