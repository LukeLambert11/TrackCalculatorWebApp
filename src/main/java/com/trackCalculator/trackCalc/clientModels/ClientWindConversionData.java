package com.trackCalculator.trackCalc.clientModels;


import lombok.*;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ClientWindConversionData {

    String event;
    float performance;
    float wind;

}
