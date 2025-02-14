package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Flight;
import com.qsp.flight_management_system.service.FlightService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FlightController {

	@Autowired
	FlightService flightService;

	@Operation(summary = "saveFlight ", description = "API is used to save the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Flight created"),
	@ApiResponse(responseCode = "404", description = "Flight not found for the given id") }) 
	
	@PostMapping("/saveFlight")
	public ResponseStructure<Flight> saveFlight(@RequestBody Flight flight) {
		return flightService.saveFlight(flight);
	}
	
	@Operation(summary = "fetchFlightById", description = "API is used to fetch Flight Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Flight fetched"),
	@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	
	@GetMapping("/fetchFlightById")
	public ResponseStructure<Flight> fetchFlightById(@RequestParam int flightId) {
		return flightService.fetchFlightById(flightId);
	}

	@Operation(summary = "fetchALLflight", description = "API is used to fetch all Flights ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Flight fetched"),
	@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	
	@GetMapping("/fetchALLflight")
	public ResponseStructureList<Flight> fetchALLflight() {
		return flightService.fetchALLflight();
	}
	
	@Operation(summary = "deleteFlightById", description = "API is used to delete Flight Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Flight deleted"),
	@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })

	@DeleteMapping("/deleteFlightById")
	public ResponseStructure<Flight> deleteFlightById(@RequestParam int flightId) {
		return flightService.deleteFlightById(flightId);
	}
	
	
	@Operation(summary = "updateFlightById", description = "API is used to update Flight Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Flight updated with new data"),
	@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	
	@PutMapping("/updateFlightById")
	public ResponseStructure<Flight> updateFlightById(@RequestParam int oldFlightId, @RequestBody Flight newFlight) {
		return flightService.updateFlightById(oldFlightId, newFlight);
	}
	
	@Operation(summary = "addExisitingFlightToExistingPilot", description = "API is used to map Exisiting Flight To Existing Pilot Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Flight maped with Exisiting Pilot data"),
	@ApiResponse(responseCode = "404", description = "Flight or pilot not found for the given id") })
	
	// one to many mapping (hear we are mappings one flight to many pilots)
	@PutMapping("/addExisitingFlightToExistingPilot")
	public ResponseStructure<Flight> addExisitingFlightToExistingPilot(@RequestParam int flightId,@RequestParam int pilotId) {
		return flightService.addExisitingFlightToExistingPilot(flightId, pilotId);
	}

	@Operation(summary = "addExistingPasangerToExistingFlight", description = "API is used map Existing Pasanger To Existing Flight Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Flight maped with Existing Pasanger"),
	@ApiResponse(responseCode = "404", description = "Flight or Pasanger  not found for the given id") })
	
	// one to many mapping (hear we are mappings one flight to many passenger)
	@PutMapping("/addExistingPasangerToExistingFlight")
	public ResponseStructure<Flight> addExistingPasangerToExistingFlight(@RequestParam int flightId, @RequestParam int pasangerId) {
		return flightService.addExistingPasangerToExistingFlight(flightId, pasangerId);
	}

	
	@Operation(summary = "addExistingAirhostessToExistingFlight", description = "API is used map Existing Pasanger To Existing Airhostess Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Flight maped with Existing Pasanger"),
	@ApiResponse(responseCode = "404", description = "Flight or Airhostess not found for the given id") })
	
	
	// one to many mapping (hear we are mappings one flight to many Air hostess )
	@PutMapping("/addExistingAirhostessToExistingFlight")
	public ResponseStructure<Flight> addExistingAirhostessToExistingFlight(@RequestParam int flightId, @RequestParam int airhostessId) {
		return flightService.addExistingAirhostessToExistingFlight(flightId, airhostessId);
	}

}
