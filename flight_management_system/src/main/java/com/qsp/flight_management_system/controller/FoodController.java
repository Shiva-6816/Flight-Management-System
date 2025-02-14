package com.qsp.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.flight_management_system.dto.Food;
import com.qsp.flight_management_system.service.FoodService;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@Operation(summary = "saveFood ", description = "API is used to save the Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Food created"),
	@ApiResponse(responseCode = "404", description = "Food not found ") })
	
	@PostMapping("/saveFood")
	public ResponseStructure<Food> saveFood(@RequestBody Food food) {
		return foodService.saveFood(food);
	} 
	
	@Operation(summary = "fetchFoodById", description = "API is used to fetch Food Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Food fetched"),
	@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	
	@GetMapping("/fetchFoodById")
	public ResponseStructure<Food> fetchFoodById(@RequestParam int foodId) {
		return foodService.fetchFoodById(foodId);
	}
	
	@Operation(summary = "fetchAllFood", description = "API is used to fetch all Food items ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Food fetched"),
	@ApiResponse(responseCode = "404", description = "Food not found ") })
	
	@GetMapping("/fetchAllFood")
	public ResponseStructureList<Food> fetchAllFood() {
		return foodService.fetchAllFood();
	}
	
	@Operation(summary = "deleteFoodById", description = "API is used to delete Food Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Successfully  Food deleted"),
	@ApiResponse(responseCode = "404", description = "Food not found for the given id ") })

	@DeleteMapping("/deleteFoodById")
	public ResponseStructure<Food> deleteFoodById( @RequestParam int foodId) {
		return foodService.deleteFoodById(foodId);
	}
	
	@Operation(summary = "updateFoodById", description = "API is used to update Food Based on Id ")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Food updated with new data"),
	@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	
	@PutMapping("/updateFoodById")
	public ResponseStructure<Food> updateFoodById(@RequestParam int OldFoodId ,@RequestBody Food newFood) {
		return foodService.updateFoodById(OldFoodId, newFood);
	}
	
}
