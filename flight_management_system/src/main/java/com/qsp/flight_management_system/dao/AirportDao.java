package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Address;
import com.qsp.flight_management_system.dto.Airport;
import com.qsp.flight_management_system.dto.Flight;
import com.qsp.flight_management_system.repo.AddressRepo;
import com.qsp.flight_management_system.repo.AirportRepo;
import com.qsp.flight_management_system.repo.FlightRepo;

@Repository
public class AirportDao {

	@Autowired
	AirportRepo airportRepo;

	@Autowired
	AddressDao addressDao;
	@Autowired
	AddressRepo addressRepo;

	@Autowired
	FlightDao flightDao;
	@Autowired
	FlightRepo flightRepo;

	public Airport saveAirport(Airport airport) {
		return airportRepo.save(airport);
	}

	public Airport fetchAirportById(int airportId) {
		// Optional is class in java. it is a java 8 feature.
		// which is specially designed to handle the exceptions.
		Optional<Airport> airport = airportRepo.findById(airportId);
		if (airport.isPresent()) {
			return airport.get();
		} else {
			return null;
		}
	}

	public List<Airport> fetchAllAirport() {
		return airportRepo.findAll();
	}

	public Airport deleteAirportById(int airportId) {
		Airport airport = fetchAirportById(airportId);
		if (airport != null) {
			airportRepo.delete(airport);
			return airport;
		} else {
			return null;
		}
	}

	public Airport updateAirportById(int oldAirportId, Airport newAirport) {
		Optional<Airport> airport = airportRepo.findById(oldAirportId);
		if (airport.isPresent()) {
			newAirport.setAirportId(oldAirportId);
			airportRepo.save(newAirport);
			return airport.get();
		} else
			return null;

	}

	// one to one mapping
	public Airport addExistingAddressToExistingAirport(int airportId, int addressId) {
		Airport airport = fetchAirportById(airportId);
		Address address = addressDao.fetchAddressById(addressId);
		airport.setAddress(address);
		return airportRepo.save(airport);
	}

	// one to many mapping
	public Airport addExistingFlightToExistingAirport(int flightId, int airportId) {
		Airport airport = fetchAirportById(airportId);
		Flight flight = flightDao.fetchFlightById(flightId);
		List<Flight> list = airport.getFlights();
		list.add(flight);
		airport.setFlights(list);
		return saveAirport(airport);
	}
	
	// one to many mapping
	public Airport addNewFlightToExistingAirport(int airportId, Flight newFlight) {
		Airport airport = fetchAirportById(airportId);
		List<Flight> list = airport.getFlights();
		list.add(newFlight);
		airport.setFlights(list);
		return saveAirport(airport);

	}
}
