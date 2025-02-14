package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Airhostess;
import com.qsp.flight_management_system.service.AirhostessService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AirhostessController {

	@Autowired
	AirhostessService airhostessService;
	
	@Operation(summary = "saveAirhostess ", description = "API is used to save the Airhostess")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Airhostess created"),
	@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	
	@PostMapping("/saveAirhostess")
	public ResponseStructure<Airhostess> saveAirhostess(@RequestBody Airhostess airhostess) {
		return  airhostessService.saveAirhostess(airhostess);
	}
	
	@Operation(summary = "fetchAirhostessById", description = "API is used to fetch Airhostess Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airhostess fetched"),
	@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	
	@GetMapping("/fetchAirhostessById")
	public ResponseStructure<Airhostess> fetchAirhostessById(@RequestParam int airhostessId) {
		return airhostessService.fetchAirhostessById(airhostessId);
	}
	
	@Operation(summary = "fetchAllAirhostess", description = "API is used to fetch all Airhostess ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airhostess fetched"),
	@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	
	@GetMapping("/fetchAllAirhostess")
	public ResponseStructureList<Airhostess> fetchAllAirhostess() {
		return airhostessService.fetchAllAirhostess();
		
	}
	
	@Operation(summary = "deleteAirhostessById", description = "API is used to delete Airhostess Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Airhostess deleted"),
	@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	
	@DeleteMapping("/deleteAirhostessById")
	public ResponseStructure<Airhostess> deleteAirhostessById(@RequestParam int airhostessId ) {
		return airhostessService.deleteAirhostessById(airhostessId);
	}
	
	@Operation(summary = "updateAirhostessById", description = "API is used to update Airhostess Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airhostess updated with new data"),
	@ApiResponse(responseCode = "404", description = "Airhostess not found for the given id") })
	
	@PutMapping("/updateAirhostessById")
	public ResponseStructure<Airhostess> updateAirhostessById(@RequestParam int oldAirhostessId ,@RequestBody Airhostess newAirhostess) {
		return airhostessService.updateAirhostessById(oldAirhostessId, newAirhostess);
	}
}
