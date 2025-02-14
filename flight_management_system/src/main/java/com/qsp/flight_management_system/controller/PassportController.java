package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Passport;
import com.qsp.flight_management_system.service.PassportService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PassportController {

	@Autowired
	PassportService passportService;

	@Operation(summary = "savePassport ", description = "API is used to save the Passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Passport created"),
	@ApiResponse(responseCode = "404", description = "Passport not found") })
	
	@PostMapping("/savePassport")
	public ResponseStructure<Passport> savePassport(@RequestBody Passport passport) {
		return passportService.savePassport(passport);
	}

	@Operation(summary = "fetchPassportById", description = "API is used to fetch Passport Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Passport fetched"),
	@ApiResponse(responseCode = "404", description = "Passport ID not found ") })
	
	@GetMapping("/fetchPassportById")
	public ResponseStructure<Passport> fetchPassportById(@RequestParam int passportId) {
		return passportService.fetchPassportById(passportId);
	}

	@Operation(summary = "fetchAllPassport", description = "API is used to fetch all Passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Passport fetched"),
	@ApiResponse(responseCode = "404", description = "Passport not found ") })
	
	@GetMapping("/fetchAllPassport")
	public ResponseStructureList<Passport> fetchAllPassport() {
		return passportService.fetchAllPassport();
	}

	@Operation(summary = "deletePassportById", description = "API is used to delete Passport Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Passport deleted"),
	@ApiResponse(responseCode = "404", description = "Passport ID not found ") })

	@DeleteMapping("/deletePassportById")
	public ResponseStructure<Passport> deletePassportById(@RequestParam int passportId) {
		return passportService.deletePassportById(passportId);
	}

	@Operation(summary = "updatePassportById", description = "API is used to update Passport Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Passport updated with new Passport data"),
	@ApiResponse(responseCode = "404", description = "Passport ID not found") })
	
	@PutMapping("/updatePassportById")
	public ResponseStructure<Passport> updatePassportById(@RequestParam int oldPassportId, @RequestBody Passport newPassport) {
		return passportService.updatePassportById(oldPassportId, newPassport);
	}
}
