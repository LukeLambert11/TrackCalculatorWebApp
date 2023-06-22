package com.trackCalculator.trackCalc.clientModels;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClientPaceCalculatorData {
    //Float distance, int hours, int minutes,  Float seconds, String distanceUnit
    Float distance;
    int hours;
    int minutes;
    Float seconds;
    String distanceUnit;

}
