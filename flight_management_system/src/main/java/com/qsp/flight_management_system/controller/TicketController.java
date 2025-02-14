package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Ticket;
import com.qsp.flight_management_system.service.TicketService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@Operation(summary = "saveTicket", description = "API is used to save the Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Ticket created"),
	@ApiResponse(responseCode = "404", description = "Ticket not found") })
	
	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}

	@Operation(summary = "fetchTicketById", description = "API is used to fetch Ticket Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Ticket fetched"),
	@ApiResponse(responseCode = "404", description = "Ticket ID not found ") })
	
	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int ticketId) {
		return ticketService.fetchTicketById(ticketId);
	}

	@Operation(summary = "fetchAllTicket", description = "API is used to fetch all Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Ticket fetched"),
	@ApiResponse(responseCode = "404", description = "Ticket not found ") })
	
	@GetMapping("/fetchAllTicket")
	public ResponseStructureList<Ticket> fetchAllTicket() {
		return ticketService.fetchAllTicket();
	}

	@Operation(summary = "deleteTicketById", description = "API is used to delete Ticket Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Ticket deleted"),
	@ApiResponse(responseCode = "404", description = "Ticket ID not found ") })

	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int ticketId) {
		return ticketService.deleteTicketById(ticketId);
	}

	@Operation(summary = "updateTicketById", description = "API is used to update Ticket Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Ticket updated with new Ticket data"),
	@ApiResponse(responseCode = "404", description = "Ticket ID not found") })
	
	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTickeId, @RequestBody Ticket newTicket) {
		return ticketService.updateTicketById(oldTickeId, newTicket);
	}

	@Operation(summary = "addExisistingTicketToExisstingPayment", description = "API is used maped the Exisisting Ticket To Existing payment ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Ticket  updated with Existing payment"),
	@ApiResponse(responseCode = "404", description = "Ticket or payment not found for the given id") })
	
	// one to one mapping
	@PutMapping("/addExisistingTicketToExisstingPayment")
	public ResponseStructure<Ticket> addExisistingTicketToExisstingPayment(int ticketId, int paymentId) {
		return ticketService.addExisistingTicketToExisstingPayment(ticketId, paymentId);
	}
}
