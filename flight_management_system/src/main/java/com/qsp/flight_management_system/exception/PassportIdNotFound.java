package com.qsp.flight_management_system.exception;

public class PassportIdNotFound extends RuntimeException {

	private String message = "Passport Id not found in the Database";

	public String getMessage() {
		return message;
	}

}

