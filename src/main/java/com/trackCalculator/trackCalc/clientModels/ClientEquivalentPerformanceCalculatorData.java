package com.trackCalculator.trackCalc.clientModels;


import lombok.*;

@Data
//@Builder
@Getter
@Setter
public class ClientEquivalentPerformanceCalculatorData {

    //for track races

    public ClientEquivalentPerformanceCalculatorData(String initialGender, String initialLocation, String initialEvent,
                                                     int hours, int minutes, float seconds, String convertingGender,
                                                     String convertingLocation, String convertingEvent) {
        this.initialGender = initialGender;
        this.initialLocation = initialLocation;
        this.initialEvent = initialEvent;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.convertingGender = convertingGender;
        this.convertingLocation = convertingLocation;
        this.convertingEvent = convertingEvent;
        this.initialPerformance = null;
        this.isField = false;
    }


    //for field events

    public ClientEquivalentPerformanceCalculatorData(String initialGender, String initialLocation, String initialEvent,
                                                     Float initialPerformance, String convertingGender,
                                                     String convertingLocation, String convertingEvent) {
        this.initialGender = initialGender;
        this.initialLocation = initialLocation;
        this.initialEvent = initialEvent;
        this.initialPerformance = initialPerformance;
        this.convertingGender = convertingGender;
        this.convertingLocation = convertingLocation;
        this.convertingEvent = convertingEvent;
        this.hours = null;
        this.minutes = null;
        this.seconds = null;
        this.isField = true;
    }


    //String gender, String location, String event, Float performance

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
