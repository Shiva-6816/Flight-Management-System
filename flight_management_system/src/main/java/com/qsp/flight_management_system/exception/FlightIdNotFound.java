package com.qsp.flight_management_system.exception;

public class FlightIdNotFound extends RuntimeException {

	private String message = "Flight Id not founnd in the Database";

	public String getMessage() {
		return message;
	}

}
