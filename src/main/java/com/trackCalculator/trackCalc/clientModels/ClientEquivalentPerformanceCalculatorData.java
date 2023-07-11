package com.trackCalculator.trackCalc.clientModels;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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

    public ClientEquivalentPerformanceCalculatorData(String initialGender, String initialLocation, String initialEvent, Float initialPerformance, Integer hours, Integer minutes, Float seconds, Boolean isField, String convertingGender, String convertingLocation, String convertingEvent) {
        this.initialGender = initialGender;
        this.initialLocation = initialLocation;
        this.initialEvent = initialEvent;
        this.initialPerformance = initialPerformance;

        if(hours == null){
            this.hours = null;
        }
        if(minutes == null){
            this.minutes = null;
        }
        if(seconds == null){
            this.seconds = null;
        }
        if(initialPerformance == null){
            this.initialPerformance = null;
        }

        this.isField = isField;
        this.convertingGender = convertingGender;
        this.convertingLocation = convertingLocation;
        this.convertingEvent = convertingEvent;
    }
}
