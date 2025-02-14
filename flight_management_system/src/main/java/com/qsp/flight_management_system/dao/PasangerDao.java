package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Address;
import com.qsp.flight_management_system.dto.Food;
import com.qsp.flight_management_system.dto.Pasanger;
import com.qsp.flight_management_system.dto.Passport;
import com.qsp.flight_management_system.dto.Seat;
import com.qsp.flight_management_system.dto.Ticket;
import com.qsp.flight_management_system.repo.PasangerRepo;

@Repository
public class PasangerDao {

	@Autowired
	PasangerRepo pasangerRepo;

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

	public Pasanger savePasanger(Pasanger pasanger) {
		return pasangerRepo.save(pasanger);
	}

	public Pasanger fetchPasangerById(int pasangerId) {
		Optional<Pasanger> pasanger = pasangerRepo.findById(pasangerId);
		if (pasanger.isPresent())
			return pasanger.get();
		else
			return null;
	}

	public List<Pasanger> fetchAllPasanger() {
		return pasangerRepo.findAll();
	}

	public Pasanger deletePasangerById(int pasangerId) {
		Pasanger pasanger = fetchPasangerById(pasangerId);
		if (pasanger != null) {
			pasangerRepo.delete(pasanger);
			return pasanger;
		} else
			return null;
	}

	public Pasanger updatePasangerById(int OldPasangerId, Pasanger newPasanger) {
		Pasanger pasanger = fetchPasangerById(OldPasangerId);
		if (pasanger != null) {
			newPasanger.setPasangerId(OldPasangerId);
			return pasangerRepo.save(newPasanger);
		} else
			return null;
	}

	// mapping one to one

	public Pasanger addExisistingPasangerToExisstingAddress(int pasangerId, int addressId) {
		Pasanger pasanger = fetchPasangerById(pasangerId);
		Address address = addressDao.fetchAddressById(addressId);
		pasanger.setAddress(address);
		return pasangerRepo.save(pasanger);
	}

	// one to one mapping
	public Pasanger addExisistingPasangerToExisstingPassport(int pasangerId, int passportId) {
		Pasanger pasanger = fetchPasangerById(pasangerId);
		Passport passport = passportDao.fetchPassportById(passportId);
		pasanger.setPassport(passport);

		return pasangerRepo.save(pasanger);
	}

	// one to one mapping
	public Pasanger addExisistingPasangerToExisstingSeat(int pasangerId, int seatId) {
		Pasanger pasanger = fetchPasangerById(pasangerId);
		Seat seat = seatDao.fetchSeatById(seatId);
		pasanger.setSeat(seat);

		return pasangerRepo.save(pasanger);
	}

	// one to many mapping
	public Pasanger addExisistingPasangerToExisstingTicket(int ticketId, int pasangerId) {
		Pasanger pasanger = fetchPasangerById(pasangerId);
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		List<Ticket> list = pasanger.getTickets();
		list.add(ticket);
		pasanger.setTickets(list);
		return savePasanger(pasanger);
	}

	// one to many mapping
	public Pasanger addExisistingPasangerToExisstingFood(int foodId, int pasangerId) {
		Pasanger pasanger = fetchPasangerById(pasangerId);
		Food food = foodDao.fetchFoodById(foodId);
		List<Food> list = pasanger.getFoods();
		list.add(food);
		pasanger.setFoods(list);
		return savePasanger(pasanger);
	}

}
