package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.AddressDao;
import com.qsp.flight_management_system.dao.FoodDao;
import com.qsp.flight_management_system.dao.PasangerDao;
import com.qsp.flight_management_system.dao.PassportDao;
import com.qsp.flight_management_system.dao.SeatDao;
import com.qsp.flight_management_system.dao.TicketDao;
import com.qsp.flight_management_system.dto.Address;
import com.qsp.flight_management_system.dto.Food;
import com.qsp.flight_management_system.dto.Pasanger;
import com.qsp.flight_management_system.dto.Passport;
import com.qsp.flight_management_system.dto.Seat;
import com.qsp.flight_management_system.dto.Ticket;
import com.qsp.flight_management_system.exception.AddressIdNotFound;
import com.qsp.flight_management_system.exception.FoodIdNotFound;
import com.qsp.flight_management_system.exception.PasangerIdNotFound;
import com.qsp.flight_management_system.exception.PassportIdNotFound;
import com.qsp.flight_management_system.exception.SeatIdNotFound;
import com.qsp.flight_management_system.exception.TicketIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class PasangerService {

	@Autowired
	PasangerDao pasangerDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	PassportDao passportDao;

	@Autowired
	SeatDao seatDao;

	@Autowired
	TicketDao ticketDao;

	@Autowired
	FoodDao foodDao;

	@Autowired
	ResponseStructure<Pasanger> responseStructure;

	@Autowired
	ResponseStructureList<Pasanger> responseStructureList;

	public ResponseStructure<Pasanger> savePasanger(Pasanger pasanger) {
		responseStructure.setMessage("Sucessfully Pasanger saved into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(pasangerDao.savePasanger(pasanger));
		return responseStructure;
	}

	public ResponseStructure<Pasanger> fetchPasangerById(int pasangerId) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		if (pasanger != null) {
			responseStructure.setMessage("Sucessfully fetched pasanger FROM DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(pasangerDao.fetchPasangerById(pasangerId));
			return responseStructure;
		} else
			throw new PasangerIdNotFound();
	}

	public ResponseStructureList<Pasanger> fetchAllPasanger() {
		responseStructureList.setMessage("Sucessfully fetched All the pasangers from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(pasangerDao.fetchAllPasanger());
		return responseStructureList;
	}

	public ResponseStructure<Pasanger> deletePasangerById(int pasangerId) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		if (pasanger != null) {
			responseStructure.setMessage("Sucessfully deleted pasanger FROM DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(pasangerDao.deletePasangerById(pasangerId));
			return responseStructure;
		} else
			throw new PasangerIdNotFound();
	}

	public ResponseStructure<Pasanger> updatePasangerById(int OldPasangerId, Pasanger newPasanger) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(OldPasangerId);
		if (pasanger != null) {
			responseStructure.setMessage("Sucessfully updated pasanger inside DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(pasangerDao.updatePasangerById(OldPasangerId, newPasanger));
			return responseStructure;
		} else
			throw new PasangerIdNotFound();
	}

	// one to one mapping
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingAddress(int pasangerId, int addressId) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		if (pasanger != null) {
			Address address = addressDao.fetchAddressById(addressId);
			if (address != null) {
				responseStructure.setMessage("Sucessfully mapped Exisisting Pasanger To Exissting Address inside DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(pasangerDao.addExisistingPasangerToExisstingAddress(pasangerId, addressId));
				return responseStructure;
			} else
				throw new AddressIdNotFound();
		} else
			throw new PasangerIdNotFound();
	}

	// one to one mapping
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingPassport(int pasangerId, int passportId) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		if (pasanger != null) {
			Passport passport = passportDao.fetchPassportById(passportId);
			if (passport != null) {
				responseStructure.setMessage("Sucessfully mapped Exisisting Pasanger To Exissting Pasport inside DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(pasangerDao.addExisistingPasangerToExisstingPassport(pasangerId, passportId));
				return responseStructure;
			} else
				throw new PassportIdNotFound();
		} else
			throw new PasangerIdNotFound();
	}

	// one to one mapping
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingSeat(int pasangerId, int seatId) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		if (pasanger != null) {
			Seat seat = seatDao.fetchSeatById(seatId);
			if (seat != null) {
				responseStructure.setMessage("Sucessfully mapped Exisisting Pasanger To Exissting seat inside DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(pasangerDao.addExisistingPasangerToExisstingSeat(pasangerId, seatId));
				return responseStructure;
			} else
				throw new SeatIdNotFound();
		} else
			throw new PasangerIdNotFound();

	}

	// one to many mapping
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingTicket(int ticketId, int pasangerId) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		if (pasanger != null) {
			Ticket ticket = ticketDao.fetchTicketById(ticketId);
			if (ticket != null) {
				responseStructure.setMessage("Sucessfully mapped Exisisting Pasanger To Exissting ticket inside DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(pasangerDao.addExisistingPasangerToExisstingTicket(ticketId, pasangerId));
				return responseStructure;
			} else
				throw new TicketIdNotFound();
		} else
			throw new PasangerIdNotFound();
	}

	// one to many mapping
	public ResponseStructure<Pasanger> addExisistingPasangerToExisstingFood(int foodId, int pasangerId) {
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		if (pasanger != null) {
			Food food = foodDao.fetchFoodById(foodId);
			if (food != null) {
				responseStructure.setMessage("Sucessfully mapped Exisisting Pasanger To Exissting food inside DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(pasangerDao.addExisistingPasangerToExisstingFood(foodId, pasangerId));
				return responseStructure;
			} else
				throw new FoodIdNotFound();
		} else
			throw new PasangerIdNotFound();
	}

}
