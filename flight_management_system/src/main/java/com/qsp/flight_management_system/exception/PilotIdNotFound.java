package com.qsp.flight_management_system.exception;

public class PilotIdNotFound extends RuntimeException {

	private String message = "Pilot Id not found in the Database";

	public String getMessage() {
		return message;
	}

}

