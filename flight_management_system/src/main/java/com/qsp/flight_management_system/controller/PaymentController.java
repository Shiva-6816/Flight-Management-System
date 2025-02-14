package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Payment;
import com.qsp.flight_management_system.service.PaymentService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Operation(summary = "savePayment ", description = "API is used to save the Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Payment created"),
	@ApiResponse(responseCode = "404", description = "Payment not found") })
	
	@PostMapping("/savePayment")
	public ResponseStructure<Payment> savePayment(@RequestBody Payment Payment) {
		return paymentService.savePayment(Payment);
	}

	@Operation(summary = "fetchPaymentById", description = "API is used to fetch Payment Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Payment fetched"),
	@ApiResponse(responseCode = "404", description = "Payment ID not found ") })
	
	@GetMapping("/fetchPaymentById")
	public ResponseStructure<Payment> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}

	@Operation(summary = "fetchAllPayment", description = "API is used to fetch all Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Payment fetched"),
	@ApiResponse(responseCode = "404", description = "Payment not found ") })
	
	@GetMapping("/fetchAllPayment")
	public ResponseStructureList<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}

	@Operation(summary = "deletePaymentById", description = "API is used to delete Payment Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Payment deleted"),
	@ApiResponse(responseCode = "404", description = "Payment ID not found ") })

	@DeleteMapping("/deletePaymentById")
	public ResponseStructure<Payment> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}

	@Operation(summary = "updatePaymentById", description = "API is used to update Payment Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Payment updated with new Payment data"),
	@ApiResponse(responseCode = "404", description = "Payment ID not found") })
	
	@PutMapping("/updatePaymentById")
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);

	}
}
