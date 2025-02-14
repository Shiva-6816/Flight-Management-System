package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Address;
import com.qsp.flight_management_system.service.AddressService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class AddressController{
	

	@Autowired
	AddressService addressService;
	
	@Operation(summary = "saveAddress ", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Address created"),
	@ApiResponse(responseCode = "404", description = "Address not found for the given id") })

	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@Operation(summary = "fetchAddressById", description = "API is used to fetch Address Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Address fetched"),
	@ApiResponse(responseCode = "404", description = "Address not found for the given id") })

	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}

	@Operation(summary = "fetchAllAddresses", description = "API is used to fetch all Address ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Address fetched"),
	@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@GetMapping("/fetchAllAddresses")
	public ResponseStructureList<Address> fetchAllAddresses() {
		return addressService.fetchAllAddresses();
	}

	@Operation(summary = "deleteAddressById", description = "API is used to delete Address Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Address deleted"),
	@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	
	@DeleteMapping("/deleteAddressById")
	public ResponseStructure<Address> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}
	
	@Operation(summary = "updateAddressById", description = "API is used to update Address Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Address updated with new data"),
	@ApiResponse(responseCode = "404", description = "Address not found for the given id") })

	@PutMapping("/updateAddressById")
	public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
}
