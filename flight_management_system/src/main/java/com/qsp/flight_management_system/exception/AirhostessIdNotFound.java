package com.qsp.flight_management_system.exception;

public class AirhostessIdNotFound extends RuntimeException{

	private String message = "Airhostess Id not founnd in the Database";

	public String getMessage() {
		return message;
	}
}
