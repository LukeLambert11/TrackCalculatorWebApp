package com.trackCalculator.trackCalc.calcLogic.calculators;

import com.trackCalculator.trackCalc.clientModels.ClientEquivalentPerformanceCalculatorData;
import com.trackCalculator.trackCalc.serverModels.ServerEquivalentPerformanceCalculatorData;

public final class EquivalentPerformanceCalculator {

    public static ServerEquivalentPerformanceCalculatorData getEquivalentPerformance
            (ClientEquivalentPerformanceCalculatorData  client){

        float initScore = HungarianScoringCalculator.getScore(client.getInitialGender(),
                client.getInitialLocation(), client.getInitialEvent(), client.getInitialPerformance(),
                client.getHours(), client.getMinutes(), client.getSeconds(), client.getIsField());

        String finalPerformance = HungarianScoringCalculator.getPerformance(client.getConvertingGender(),
                client.getConvertingLocation(), client.getConvertingEvent(), initScore);

        return new ServerEquivalentPerformanceCalculatorData(finalPerformance);

    }
}
