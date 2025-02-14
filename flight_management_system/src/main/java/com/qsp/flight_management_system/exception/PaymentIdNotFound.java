package com.qsp.flight_management_system.exception;

public class PaymentIdNotFound extends RuntimeException {

	private String message = "Payment Id not found in the Database";

	public String getMessage() {
		return message;
	}

}
