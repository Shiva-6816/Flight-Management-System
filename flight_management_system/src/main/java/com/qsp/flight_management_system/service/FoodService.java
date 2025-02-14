package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.FoodDao;
import com.qsp.flight_management_system.dto.Food;
import com.qsp.flight_management_system.exception.FoodIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;

	@Autowired
	ResponseStructure<Food> responseStructure;

	@Autowired
	ResponseStructureList<Food> responseStructureList;

	public ResponseStructure<Food> saveFood(Food food) {
		responseStructure.setMessage("Sucessfully food added to menu in Database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(foodDao.saveFood(food));
		return responseStructure;
	}

	public ResponseStructure<Food> fetchFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
			responseStructure.setMessage("Sucessfully food fetched from the  Database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(foodDao.fetchFoodById(foodId));
			return responseStructure;
		} else
			throw new FoodIdNotFound();
	}

	public ResponseStructureList<Food> fetchAllFood() {
		responseStructureList.setMessage("Sucessfully fetched All the food from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(foodDao.fetchAllFood());
		return responseStructureList;

	}

	public ResponseStructure<Food> deleteFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
		responseStructure.setMessage("Sucessfully food was deleted from the  Database");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return responseStructure;
		} else
			throw new FoodIdNotFound();
	}

	public ResponseStructure<Food> updateFoodById(int OldFoodId, Food newFood) {
		Food food = foodDao.fetchFoodById(OldFoodId);
		if (food != null) {
		responseStructure.setMessage("Sucessfully food was Updated in the  Database");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(foodDao.updateFoodById(OldFoodId, newFood));
		return responseStructure;
		} else
			throw new FoodIdNotFound();
	}
}
