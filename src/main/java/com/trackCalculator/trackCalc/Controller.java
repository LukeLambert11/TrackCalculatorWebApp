package com.trackCalculator.trackCalc;

import com.trackCalculator.trackCalc.clientModels.ClientEquivalentPerformanceCalculatorData;
import com.trackCalculator.trackCalc.clientModels.ClientPaceCalculatorData;
import com.trackCalculator.trackCalc.clientModels.ClientTimeCalculatorData;
import com.trackCalculator.trackCalc.clientModels.ClientWindConversionData;
import com.trackCalculator.trackCalc.serverModels.ServerEquivalentPerformanceCalculatorData;
import com.trackCalculator.trackCalc.serverModels.ServerPaceCalculatorData;
import com.trackCalculator.trackCalc.serverModels.ServerTimeCalculatorData;
import com.trackCalculator.trackCalc.serverModels.ServerWindConversionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    Services services;

    Controller(Services services){
        this.services = services;
    }

    @GetMapping(path = "/wind-calculator")
    public ServerWindConversionData getWindConversion(ClientWindConversionData clientData){
        return services.getWindConversion(clientData);
    }

    @GetMapping(path = "/time-calculator")
    public ServerTimeCalculatorData getTimeCalculation(ClientTimeCalculatorData clientData){
        return services.getCalculatedTime(clientData);
    }

    @GetMapping(path = "/pace-calculator")
    public ServerPaceCalculatorData getPaceConversion(ClientPaceCalculatorData clientData){
        return services.getCalculatedPace(clientData);
    }

    @GetMapping(path = "/equivalent-performance-calculator")
    public ServerEquivalentPerformanceCalculatorData
    getEquivalentPerformance(ClientEquivalentPerformanceCalculatorData clientData){
        return services.getEquivalentPerformance(clientData);
    }


}
