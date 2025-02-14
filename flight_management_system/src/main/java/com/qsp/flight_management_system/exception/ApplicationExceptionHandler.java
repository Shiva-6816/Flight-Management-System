package com.qsp.flight_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.flight_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(AirhostessIdNotFound.class)
	public ResponseStructure<String> airhostessIdNotFound(AirhostessIdNotFound addressIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure;
	}
	
	
	@ExceptionHandler(AirportIdNotFound.class)
	public ResponseStructure<String> airportIdNotFound(AirportIdNotFound airportIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(airportIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(FlightIdNotFound.class)
	public ResponseStructure<String> flightIdNotFound(FlightIdNotFound flightIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(flightIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> foodIdNotFound(FoodIdNotFound foodIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(foodIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PasangerIdNotFound.class)
	public ResponseStructure<String> pasangerIdNotFound(PasangerIdNotFound pasangerIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(pasangerIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PassportIdNotFound.class)
	public ResponseStructure<String> passportIdNotFound(PassportIdNotFound passportIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(passportIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(paymentIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PilotIdNotFound.class)
	public ResponseStructure<String> pilotIdNotFound(PilotIdNotFound  pilotIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(pilotIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> seatIdNotFound(SeatIdNotFound seatIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(seatIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String> ticketIdNotFound(TicketIdNotFound ticketIdNotFound) {
		responseStructure.setMessage("Id not found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ticketIdNotFound.getMessage());
		return responseStructure;
	}
	
	
	

}
