package com.vehicle.exceptions;

public class VehicleNotFoundException extends RuntimeException {

	  VehicleNotFoundException(String vin) {
	    super("Could not find vehicle  " + vin);
	  }
	}