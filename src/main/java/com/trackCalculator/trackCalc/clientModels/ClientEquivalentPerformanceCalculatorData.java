package com.trackCalculator.trackCalc.clientModels;


import lombok.*;

@Data
@AllArgsConstructor
//@Builder
@Getter
@Setter
public class ClientEquivalentPerformanceCalculatorData {


    String initialGender;
    String initialLocation;
    String initialEvent;
    Float initialPerformance;
    Integer hours;
    Integer minutes;
    Float seconds;
    Boolean isField;

    String convertingGender;
    String convertingLocation;
    String convertingEvent;
}
