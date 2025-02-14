package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.AddressDao;
import com.qsp.flight_management_system.dao.AirportDao;
import com.qsp.flight_management_system.dao.FlightDao;
import com.qsp.flight_management_system.dto.Address;
import com.qsp.flight_management_system.dto.Airport;
import com.qsp.flight_management_system.dto.Flight;
import com.qsp.flight_management_system.exception.AddressIdNotFound;
import com.qsp.flight_management_system.exception.AirportIdNotFound;
import com.qsp.flight_management_system.exception.FlightIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class AirportService {

	@Autowired
	AirportDao airportDao;

	@Autowired
	AddressDao addressDao;
	@Autowired
	FlightDao flightDao;

	@Autowired
	ResponseStructure<Airport> responseStructure;

	@Autowired
	ResponseStructureList<Airport> responseStructureList;

	public ResponseStructure<Airport> saveAirport(Airport airport) {
		responseStructure.setMessage("Sucessfully ===Airport saved=== into DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(airportDao.saveAirport(airport));
		return responseStructure;
	}

	public ResponseStructure<Airport> fetchAirportById(int airportId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("Sucessfully ===FETCHED AIRPORT=== FROM DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airportDao.fetchAirportById(airportId));
			return responseStructure;
		} else
			throw new AirportIdNotFound();
	}

	public ResponseStructureList<Airport> fetchAllAirport() {
		responseStructureList.setMessage("Sucessfully fetched All the Airport from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(airportDao.fetchAllAirport());
		return responseStructureList;
	}

	public ResponseStructure<Airport> deleteAirportById(int airportId) {
		Airport airport = airportDao.deleteAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("Sucessfully ===Deleted AIRPORT=== FROM DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.fetchAirportById(airportId));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructure<Airport> updateAirportById(int oldAirportId, Airport newAirport) {
		Airport airport = airportDao.fetchAirportById(oldAirportId);
		if (airport != null) {
			responseStructure.setMessage("Sucessfully ===Updated AIRPORT=== FROM DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.updateAirportById(oldAirportId, newAirport));
			return responseStructure;
		} else
			throw new AirportIdNotFound();
	}

	// one to one mapping
	public ResponseStructure<Airport> addExistingAddressToExistingAirport(int airportId, int addressId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			Address address = addressDao.fetchAddressById(addressId);
			if (address != null) {
				responseStructure.setMessage("Sucessfully === Mapped Existing Address To Existing Airport ===  in DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(airportDao.addExistingAddressToExistingAirport(airportId, addressId));
				return responseStructure;
			} else
				throw new AddressIdNotFound();
		} else
			throw new AirportIdNotFound();

	}

	// one to many mapping

	public ResponseStructure<Airport> addExistingFlightToExistingAirport(int flightId, int airportId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			Flight flight = flightDao.fetchFlightById(flightId);
			if (flight != null) {
				responseStructure
						.setMessage("Sucessfully === Mapped Existing flight To Existing Airport === in DataBase");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(airportDao.addExistingFlightToExistingAirport(flightId, airportId));
				return responseStructure;
			} else
				throw new FlightIdNotFound();
		} else
			throw new AirportIdNotFound();

	}

	// one to many mapping

	public ResponseStructure<Airport> addNewFlightToExistingAirport(int airportId, Flight newFlight) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("Sucessfully === Mapped NEW FLIGHT To Existing AIRPORT === in DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.addNewFlightToExistingAirport(airportId, newFlight));
			return responseStructure;
		} else
			throw new AirportIdNotFound();

	}

}
