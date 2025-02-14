package com.qsp.flight_management_system.exception;

public class SeatIdNotFound extends RuntimeException {

	private String message = "Seat Id not found in the Database";

	public String getMessage() {
		return message;
	}

}

