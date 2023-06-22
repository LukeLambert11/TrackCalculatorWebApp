package com.trackCalculator.trackCalc.serverModels;


import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ServerPaceCalculatorData {
    String milePace;
    String kilometerPace;
}
