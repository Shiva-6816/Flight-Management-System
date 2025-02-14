package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Pilot;
import com.qsp.flight_management_system.service.PilotService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PilotController {

	@Autowired
	PilotService pilotService;

	@Operation(summary = "savePilot ", description = "API is used to save the Pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Pilot created"),
	@ApiResponse(responseCode = "404", description = "Pilot not found") })
	
	@PostMapping("/savePilot")
	public ResponseStructure<Pilot> savePilot(@RequestBody Pilot pilot) {
		return pilotService.savePilot(pilot);
	}

	@Operation(summary = "fetchPilotById", description = "API is used to fetch Pilot Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pilot fetched"),
	@ApiResponse(responseCode = "404", description = "Pilot ID not found ") })
	
	@GetMapping("/fetchPilotById")
	public ResponseStructure<Pilot> fetchPilotById(@RequestParam int pilotId) {
		return pilotService.fetchPilotById(pilotId);
	}

	@Operation(summary = "fetchAllPilot", description = "API is used to fetch all Pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pilot fetched"),
	@ApiResponse(responseCode = "404", description = "Pilot not found ") })
	
	@GetMapping("/fetchAllPilot")
	public ResponseStructureList<Pilot> fetchAllPilot() {
		return pilotService.fetchAllPilot();
	}

	@Operation(summary = "deletePilotById", description = "API is used to delete Pilot Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Pilot deleted"),
	@ApiResponse(responseCode = "404", description = "Pilot ID not found ") })

	@DeleteMapping("/deletePilotById")
	public ResponseStructure<Pilot> deletePilotById(@RequestParam int pilotId) {
		return pilotService.deletePilotById(pilotId);
	}

	@Operation(summary = "updatePilotById", description = "API is used to update Pilot Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Pilot updated with new Pilot data"),
	@ApiResponse(responseCode = "404", description = "Pilot ID not found") })
	
	@PutMapping("/updatePilotById")
	public ResponseStructure<Pilot> updatePilotById(@RequestParam int oldPilotId, @RequestBody Pilot newPilot) {
		return pilotService.updatePilotById(oldPilotId, newPilot);
	}
}
