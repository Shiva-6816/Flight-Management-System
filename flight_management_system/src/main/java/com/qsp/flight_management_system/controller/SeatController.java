package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Seat;
import com.qsp.flight_management_system.service.SeatService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SeatController {

	@Autowired
	SeatService seatService;
	
	@Operation(summary = "saveSeat ", description = "API is used to save the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Seat created"),
	@ApiResponse(responseCode = "404", description = "Seat not found") })
	
	@PostMapping("/saveSeat")
	public ResponseStructure<Seat> saveSeat(@RequestBody Seat seat) {
		return seatService.saveSeat(seat);
	}

	@Operation(summary = "fetchSeatById", description = "API is used to fetch Seat Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Seat fetched"),
	@ApiResponse(responseCode = "404", description = "Seat ID not found ") })
	
	@GetMapping("/fetchSeatById")
	public ResponseStructure<Seat> fetchSeatById(@RequestParam int seatId) {
		return seatService.fetchSeatById(seatId);
	}

	@Operation(summary = "fetchAllSeat", description = "API is used to fetch all Seats")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Seat fetched"),
	@ApiResponse(responseCode = "404", description = "Seat not found ") })
	
	@GetMapping("/fetchAllSeat")
	public ResponseStructureList<Seat> fetchAllSeat() {
		return seatService.fetchAllSeat();
	}

	@Operation(summary = "deleteSeatById", description = "API is used to delete Seat Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Seat deleted"),
	@ApiResponse(responseCode = "404", description = "Seat ID not found ") })

	@DeleteMapping("/deleteSeatById")
	public ResponseStructure<Seat> deleteSeatById(@RequestParam int seatId) {
		return seatService.deleteSeatById(seatId);
	}

	@Operation(summary = "updateSeatById", description = "API is used to update Seat Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Seat updated with new Seat data"),
	@ApiResponse(responseCode = "404", description = "Seat ID not found") })
	
	@PutMapping("/updateSeatById")
	public ResponseStructure<Seat> updateSeatById(@RequestParam int oldSeatId, @RequestBody Seat newsSeat) {
		return seatService.updateSeatById(oldSeatId, newsSeat);
	}
 
}
