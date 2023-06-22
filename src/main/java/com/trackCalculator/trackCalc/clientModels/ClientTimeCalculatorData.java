package com.trackCalculator.trackCalc.clientModels;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClientTimeCalculatorData {

    //Float distance, int hourPace, int minutePace, float secondPace, String paceUnits
    Float distance;
    int hourPace;
    int minutePace;
    float secondPace;
    String paceUnits;

}
