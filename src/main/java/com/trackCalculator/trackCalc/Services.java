package com.trackCalculator.trackCalc;

import com.trackCalculator.trackCalc.calcLogic.calculators.EquivalentPerformanceCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.PaceCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.TimeCalculator;
import com.trackCalculator.trackCalc.calcLogic.calculators.WindCalculator;
import com.trackCalculator.trackCalc.clientModels.ClientEquivalentPerformanceCalculatorData;
import com.trackCalculator.trackCalc.clientModels.ClientPaceCalculatorData;
import com.trackCalculator.trackCalc.clientModels.ClientTimeCalculatorData;
import com.trackCalculator.trackCalc.clientModels.ClientWindConversionData;
import com.trackCalculator.trackCalc.serverModels.ServerEquivalentPerformanceCalculatorData;
import com.trackCalculator.trackCalc.serverModels.ServerPaceCalculatorData;
import com.trackCalculator.trackCalc.serverModels.ServerTimeCalculatorData;
import com.trackCalculator.trackCalc.serverModels.ServerWindConversionData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class Services {

    public ServerWindConversionData getWindConversion(ClientWindConversionData client){
        //no input greater than 60 seconds
        return WindCalculator.getConvertedPerformance(client.getEvent(), client.getPerformance(), client.getWind());
    }

    public ServerTimeCalculatorData getCalculatedTime(ClientTimeCalculatorData client){

       return TimeCalculator.calculateTime(client.getDistance(), client.getHourPace(),
                client.getMinutePace(), client.getSecondPace(), client.getPaceUnits());


    }

    public ServerPaceCalculatorData getCalculatedPace(ClientPaceCalculatorData client){
       return PaceCalculator.calculateAveragePace(client.getDistance(), client.getHours(), client.getMinutes(),
                client.getSeconds(), client.getDistanceUnit());
    }

    public ServerEquivalentPerformanceCalculatorData getEquivalentPerformance(ClientEquivalentPerformanceCalculatorData clientEquivalentPerformanceCalculatorData){
        return EquivalentPerformanceCalculator.getEquivalentPerformance(clientEquivalentPerformanceCalculatorData);
    }


}
