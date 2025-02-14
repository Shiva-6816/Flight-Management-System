package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Pasanger;
import com.qsp.flight_management_system.service.PasangerService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PasangerController {

	@Autowired
	PasangerService pasangerService;

	@Operation(summary = "savePasanger ", description = "API is used to save the Pasanger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Pasanger created"),
	@ApiResponse(responseCode = "404", description = "Pasanger not found") })
	
	@PostMapping("/savePasanger")
	public ResponseStructure<Pasanger> savePasanger(@RequestBody Pasanger pasanger) {
		return pasangerService.savePasanger(pasanger);
	}

	@Operation(summary = "fetchPasangerById", description = "API is used to fetch Pasanger Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasanger fetched"),
	@ApiResponse(responseCode = "404", description = "Pasanger ID not found ") })
	
	@GetMapping("/fetchPasangerById")
	public ResponseStructure<Pasanger> fetchPasangerById(@RequestParam int pasangerId) {
		return pasangerService.fetchPasangerById(pasangerId);
	}

	@Operation(summary = "fetchAllFood", description = "API is used to fetch all Pasangers")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasangers fetched"),
	@ApiResponse(responseCode = "404", description = "Pasanger not found ") })
	
	@GetMapping("/fetchAllPasanger")
	public ResponseStructureList<Pasanger> fetchAllPasanger() {
		return pasangerService.fetchAllPasanger();
	}

	@Operation(summary = "deletePasangerById", description = "API is used to delete Pasanger Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Pasanger deleted"),
	@ApiResponse(responseCode = "404", description = "Pasanger ID not found ") })

	@DeleteMapping("/deletePasangerById")
	public ResponseStructure<Pasanger> deletePasangerById(@RequestParam int pasangerId) {
		return pasangerService.deletePasangerById(pasangerId);
	}

	@Operation(summary = "updatePasangerById", description = "API is used to update Pasanger Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasanger updated with new Pasanger data"),
	@ApiResponse(responseCode = "404", description = "Pasanger ID not found") })
	
	@PutMapping("/updatePasangerById")
	public ResponseStructure<Pasanger> updatePasangerById(@RequestParam int OldPasangerId, @RequestBody Pasanger newPasanger) {
		return pasangerService.updatePasangerById(OldPasangerId, newPasanger);
	}

	@Operation(summary = "addExisistingPasangerToExisstingAddress", description = "API is used to map Exisisting Pasanger To Exissting Address Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasanger updated with Exissting Address data"),
	@ApiResponse(responseCode = "404", description = "Pasanger or Address ID not found") })
	
	// one to one mapping
	@PutMapping("/addExisistingPasangerToExisstingAddress")
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingAddress(@RequestParam int pasangerId, @RequestParam int addressId) {
		return pasangerService.addExisistingPasangerToExisstingAddress(pasangerId, addressId);
	}

	@Operation(summary = "addExisistingPasangerToExisstingPassport", description = "API is used to map Exisisting Pasanger To Exissting Passport Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasanger updated with Existing Passport"),
	@ApiResponse(responseCode = "404", description = "Pasanger or Passport ID not found") })
	
	// one to one mapping
	@PutMapping("/addExisistingPasangerToExisstingPassport")
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingPassport(@RequestParam int pasangerId,
			@RequestParam int passportId) {
		return pasangerService.addExisistingPasangerToExisstingPassport(pasangerId, passportId);
	}

	@Operation(summary = "addExisistingPasangerToExisstingSeat", description = "API is used to map Exisisting Pasanger To Exissting Seat Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasanger updated with Exissting Seat "),
	@ApiResponse(responseCode = "404", description = "Pasanger or Seat ID not found") })
	
	// one to one mapping
	@PutMapping("/addExisistingPasangerToExisstingSeat")
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingSeat(@RequestParam int pasangerId, @RequestParam int seatId) {
		return pasangerService.addExisistingPasangerToExisstingSeat(pasangerId, seatId);
	}

	@Operation(summary = "addExisistingPasangerToExisstingTicket", description = "API is used to map Exisisting Pasanger To Exissting Ticket Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasanger updated with Exissting Ticket "),
	@ApiResponse(responseCode = "404", description = "Pasanger or Ticket ID not found") })
	
	// one to many mapping
	@PutMapping("/addExisistingPasangerToExisstingTicket")
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingTicket(@RequestParam int ticketId, @RequestParam int pasangerId) {
		return pasangerService.addExisistingPasangerToExisstingTicket(ticketId, pasangerId);
	}
	
	@Operation(summary = "addExisistingPasangerToExisstingFood", description = "API is used to map Exisisting Pasanger To Exissting Food Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pasanger updated with Exissting Food "),
	@ApiResponse(responseCode = "404", description = "Pasanger or Food ID not found") })
	
	// one to many mapping
	@PutMapping("/addExisistingPasangerToExisstingFood")
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingFood(@RequestParam int foodId,@RequestParam int pasangerId) {
		return pasangerService.addExisistingPasangerToExisstingFood(foodId, pasangerId);
	}

}
