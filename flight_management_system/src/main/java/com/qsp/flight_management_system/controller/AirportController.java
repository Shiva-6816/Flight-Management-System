package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Airport;
import com.qsp.flight_management_system.dto.Flight;
import com.qsp.flight_management_system.service.AirportService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AirportController {

	@Autowired
	AirportService airportService;

	@Operation(summary = "saveAirport ", description = "API is used to save the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Airport created"),
	@ApiResponse(responseCode = "404", description = "Airport not found ") })
	
	@PostMapping("/saveAirport")
	public ResponseStructure<Airport> saveAirport(@RequestBody Airport airport) {
		return airportService.saveAirport(airport);
	}
	
	@Operation(summary = "fetchAirportById", description = "API is used to fetch Airport Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport fetched"),
	@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	
	@GetMapping("/fetchAirportById")
	public ResponseStructure<Airport> fetchAirportById(@RequestParam int airportId) {
		return airportService.fetchAirportById(airportId);
	}
	
	@Operation(summary = "fetchAllAirport", description = "API is used to fetch all Airports ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport fetched"),
	@ApiResponse(responseCode = "404", description = "Airport not found") })
	
	@GetMapping("/fetchAllAirport")
	public ResponseStructureList<Airport> fetchAllAirport() {
		return airportService.fetchAllAirport();
	}
	
	@Operation(summary = "deleteAirportById", description = "API is used to delete Airport Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Airport deleted"),
	@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })

	@DeleteMapping("/deleteAirportById")
	public ResponseStructure<Airport> deleteAirportById(@RequestParam int airportId) {
		return airportService.deleteAirportById(airportId);
	}

	@Operation(summary = "updateAirportById", description = "API is used to update Airport Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport updated with new data"),
	@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	
	@PutMapping("/updateAirportById")
	public ResponseStructure<Airport> updateAirportById(@RequestParam int oldAirportId, @RequestBody Airport newAirport) {

		return airportService.updateAirportById(oldAirportId, newAirport);
	}

	@Operation(summary = "addExistingAddressToExistingAirport", description = "API is used map the Existing Address To Existing Airport ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport updated with Existing Address"),
	@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })	
	//one to one 
	
	@PutMapping("/addExistingAddressToExistingAirport")
	public ResponseStructure<Airport> addExistingAddressToExistingAirport(@RequestParam int airportId, @RequestParam int addressId) {
		return airportService.addExistingAddressToExistingAirport(airportId, addressId);
	}
	
	@Operation(summary = "addExistingFlightToExistingAirport", description = "API is used map the Existing Flight To Existing Airport ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport updated with Existing flight"),
	@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	
	//one to many (hear we are mapping Existing flight to Existing Airport )
	@PutMapping("/addExistingFlightToExistingAirport")
	public ResponseStructure<Airport> addExistingFlightToExistingAirport(@RequestParam int flightId, @RequestParam int airportId) {
		return airportService.addExistingFlightToExistingAirport(flightId, airportId);
	}
	
	@Operation(summary = "addNewFlightToExistingAirport", description = "API is used maped the new Flight To Existing Airport ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport updated with new flight"),
	@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	
	// one to many(hear we are mapping New flight to Existing Airport)
	@PutMapping("/addNewFlightToExistingAirport")
	public ResponseStructure<Airport> addNewFlightToExistingAirport(@RequestParam int airportId ,@RequestBody Flight newFlight ) {
		return airportService.addNewFlightToExistingAirport(airportId, newFlight);
	}
}
