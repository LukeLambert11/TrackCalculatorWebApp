package com.trackCalculator.trackCalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackCalcApplication.class, args);
	}

}



/*TODO
   fix HungarianScoring to work for field events
   		worked on this needs maybe its +- the inverse get performance function is not working
   Add checks for data entered on hungarian calculator
   make front end
   put front end in the static directory
   figure out how to host probably on AWS
   add controller
   add service
 */