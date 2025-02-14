package com.qsp.flight_management_system.exception;

public class AirportIdNotFound extends RuntimeException{

	private String message = "Ariport Id not founnd in the Database";

	public String getMessage() {
		return message;
	}
	
}
