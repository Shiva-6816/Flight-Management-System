package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Airhostess;
import com.qsp.flight_management_system.dto.Flight;
import com.qsp.flight_management_system.dto.Pasanger;
import com.qsp.flight_management_system.dto.Pilot;
import com.qsp.flight_management_system.repo.FlightRepo;

@Repository
public class FlightDao {

	@Autowired
	FlightRepo flightRepo;

	@Autowired
	PilotDao pilotDao;

	@Autowired
	PasangerDao pasangerDao;

	@Autowired
	AirhostessDao airhostessDao;

	public Flight saveFlight(Flight flight) {
		return flightRepo.save(flight);
	}

	public Flight fetchFlightById(int flightId) {
		Optional<Flight> flight = flightRepo.findById(flightId);
		if (flight.isPresent()) {
			return flight.get();
		}
		else {
			return null;
		}
	}

	public List<Flight> fetchALLflight() {
		return flightRepo.findAll();
	}

	public Flight deleteFlightById(int flightId) {
		Flight flight = fetchFlightById(flightId);
		if(flight != null) {
			flightRepo.delete(flight);
			return flight;
		}
		return null;
	}

	public Flight updateFlightById(int oldFlightId, Flight newFlight) {
		Optional<Flight> flight = flightRepo.findById(oldFlightId);
		if (flight.isPresent()) {
			newFlight.setFlightId(oldFlightId);
			flightRepo.save(newFlight);
			return flight.get();
		}
		else 
			return null;
	}

	// one to many mapping (hear we are mappings one flight to many pilots)

	public Flight addExisitingFlightToExistingPilot(int flightId, int pilotId) {
		Flight flight = fetchFlightById(flightId);
		Pilot pilot = pilotDao.fetchPilotById(pilotId);
		List<Pilot> list = flight.getPilots();
		list.add(pilot);
		flight.setPilots(list);
		return saveFlight(flight);
	}

	// one to many mapping (hear we are mappings one flight to many passenger)

	public Flight addExistingPasangerToExistingFlight(int flightId, int pasangerId) {
		Flight flight = fetchFlightById(flightId);
		Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
		List<Pasanger> list = flight.getPasangers();
		list.add(pasanger);
		flight.setPasangers(list);
		return saveFlight(flight);

	}

	// one to many mapping (hear we are mappings one flight to many Air hostess )

	public Flight addExistingAirhostessToExistingFlight(int flightId, int airhostessId) {
		Flight flight = fetchFlightById(flightId);
		Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
		List<Airhostess> list = flight.getAirhostesses();
		list.add(airhostess);
		flight.setAirhostesses(list);
		return saveFlight(flight);
	}

}
