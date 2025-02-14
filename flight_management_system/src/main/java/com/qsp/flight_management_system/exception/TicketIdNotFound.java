package com.qsp.flight_management_system.exception;

public class TicketIdNotFound extends RuntimeException {

	private String message = "Ticket Id not founnd in the Database";

	public String getMessage() {
		return message;
	}

}
