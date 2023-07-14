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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    Services services;

    Controller(Services services){
        this.services = services;
    }

    @GetMapping(path = "/windCalculator")
    public ServerWindConversionData getWindConversion(ClientWindConversionData clientData){
        return services.getWindConversion(clientData);
    }

    @GetMapping(path = "/timeCalculator")
    public ServerTimeCalculatorData getTimeCalculation(ClientTimeCalculatorData clientData){
        return services.getCalculatedTime(clientData);
    }

    @GetMapping(path = "/paceCalculator")
    public ServerPaceCalculatorData getPaceConversion(@ModelAttribute ClientPaceCalculatorData clientData){
        return services.getCalculatedPace(clientData);
    }

    @GetMapping(path = "/iaafCalculator")
    public ServerEquivalentPerformanceCalculatorData
    getEquivalentPerformance(ClientEquivalentPerformanceCalculatorData clientData){
        return services.getEquivalentPerformance(clientData);
    }


}
