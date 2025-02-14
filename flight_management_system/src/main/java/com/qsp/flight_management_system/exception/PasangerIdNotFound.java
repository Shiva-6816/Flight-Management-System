package com.qsp.flight_management_system.exception;

public class PasangerIdNotFound extends RuntimeException {

	private String message = "Pasanger Id not found in the Database";

	public String getMessage() {
		return message;
	}

}

