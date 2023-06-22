package com.trackCalculator.trackCalc.clientModels;


import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClientEquivalentPerformanceCalculatorData {


    //String gender, String location, String event, Float performance

    String initialGender;
    String initialLocation;
    String initialEvent;
    Float initialPerformance;

    String convertingGender;
    String convertingLocation;
    String convertingEvent;
}
