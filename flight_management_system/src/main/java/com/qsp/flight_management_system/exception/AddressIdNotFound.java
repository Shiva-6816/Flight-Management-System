package com.qsp.flight_management_system.exception;

public class AddressIdNotFound  extends RuntimeException{

	private String message = "Address Id not founnd in the Database";

	public String getMessage() {
		return message;
	}
	

}
