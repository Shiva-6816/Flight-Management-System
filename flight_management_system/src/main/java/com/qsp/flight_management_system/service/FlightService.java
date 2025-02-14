package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.AirhostessDao;
import com.qsp.flight_management_system.dao.FlightDao;
import com.qsp.flight_management_system.dao.PasangerDao;
import com.qsp.flight_management_system.dao.PilotDao;
import com.qsp.flight_management_system.dto.Airhostess;
import com.qsp.flight_management_system.dto.Flight;
import com.qsp.flight_management_system.dto.Pasanger;
import com.qsp.flight_management_system.dto.Pilot;
import com.qsp.flight_management_system.exception.AirhostessIdNotFound;
import com.qsp.flight_management_system.exception.FlightIdNotFound;
import com.qsp.flight_management_system.exception.PasangerIdNotFound;
import com.qsp.flight_management_system.exception.PilotIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class FlightService {

	@Autowired
	FlightDao flightDao;
	@Autowired
	PilotDao pilotDao;
	@Autowired
	PasangerDao pasangerDao;
	@Autowired
	AirhostessDao airhostessDao;

	@Autowired
	ResponseStructure<Flight> responseStructure;

	@Autowired
	ResponseStructureList<Flight> responseStructureList;

	public ResponseStructure<Flight> saveFlight(Flight flight) {
		responseStructure.setMessage("Sucessfully Flight Saved inside the DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(flightDao.saveFlight(flight));
		return responseStructure;
	}

	public ResponseStructure<Flight> fetchFlightById(int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			responseStructure.setMessage("Sucessfully flight Fetched from the DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(flightDao.fetchFlightById(flightId));
			return responseStructure;
		} else
			throw new FlightIdNotFound();
	}

	public ResponseStructureList<Flight> fetchALLflight() {
		responseStructureList.setMessage("Sucessfully fetched All the flights from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(flightDao.fetchALLflight());
		return responseStructureList;
	}

	public ResponseStructure<Flight> deleteFlightById(int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			responseStructure.setMessage("Sucessfully flight deleted from the DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.deleteFlightById(flightId));
			return responseStructure;
		} else
			throw new FlightIdNotFound();
	}

	public ResponseStructure<Flight> updateFlightById(int oldFlightId, Flight newFlight) {
		Flight flight = flightDao.fetchFlightById(oldFlightId);
		if (flight != null) {
			responseStructure.setMessage("Sucessfully flight Updated the DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.updateFlightById(oldFlightId, newFlight));
			return responseStructure;
		} else
			throw new FlightIdNotFound();

	}

	// one to many mapping (hear we are mappings one flight to many pilots)
	public ResponseStructure<Flight> addExisitingFlightToExistingPilot(int flightId, int pilotId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			Pilot pilot = pilotDao.fetchPilotById(pilotId);
			if (pilot != null) {
				responseStructure.setMessage("Sucessfully Mapped Exisiting Flight To Existing Pilot in DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(flightDao.addExisitingFlightToExistingPilot(flightId, pilotId));
				return responseStructure;
			} else {
				throw new PilotIdNotFound();
			}
		} else
			throw new FlightIdNotFound();
	}

	// one to many mapping (hear we are mappings one flight to many passenger)

	public ResponseStructure<Flight> addExistingPasangerToExistingFlight(int flightId, int pasangerId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			Pasanger pasanger = pasangerDao.fetchPasangerById(pasangerId);
			if (pasanger != null) {
				responseStructure.setMessage("Sucessfully Mapped Exisiting Flight To Existing Pasanger in DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(flightDao.addExistingPasangerToExistingFlight(flightId, pasangerId));
				return responseStructure;
			} else {
				throw new PasangerIdNotFound();
			}
		} else
			throw new FlightIdNotFound();

	}

	public ResponseStructure<Flight> addExistingAirhostessToExistingFlight(int flightId, int airhostessId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			Airhostess airhostess=airhostessDao.fetchAirhostessById(airhostessId);
			if ( airhostess != null) {
				responseStructure.setMessage("Sucessfully Mapped Exisiting Flight To Existing airhostess in DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(flightDao.addExistingAirhostessToExistingFlight(flightId, airhostessId));
				return responseStructure;
			} else {
				throw new AirhostessIdNotFound();
			}
		} else
			throw new FlightIdNotFound();
	}
}
