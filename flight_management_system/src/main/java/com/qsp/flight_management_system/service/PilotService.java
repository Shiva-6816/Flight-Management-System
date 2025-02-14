package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.PilotDao;
import com.qsp.flight_management_system.dto.Pilot;
import com.qsp.flight_management_system.exception.PilotIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class PilotService {

	@Autowired
	PilotDao pilotDao;

	@Autowired
	ResponseStructure<Pilot> responseStructure;

	@Autowired
	ResponseStructureList<Pilot> responseStructureList;

	public ResponseStructure<Pilot> savePilot(Pilot pilot) {
		responseStructure.setMessage("Sucessfully pilot added inside Database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(pilotDao.savePilot(pilot));
		return responseStructure;
	}

	public ResponseStructure<Pilot> fetchPilotById(int pilotId) {
		Pilot pilot = pilotDao.fetchPilotById(pilotId);
		if (pilot != null) {
			responseStructure.setMessage("Sucessfully pilot fetched from Database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(pilotDao.fetchPilotById(pilotId));
			return responseStructure;
		} else
			throw new PilotIdNotFound();
	}

	public ResponseStructureList<Pilot> fetchAllPilot() {
		responseStructureList.setMessage("Sucessfully fetched All the pilots from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(pilotDao.fetchAllPilot());
		return responseStructureList;
	}

	public ResponseStructure<Pilot> deletePilotById(int pilotId) {
		Pilot pilot = pilotDao.fetchPilotById(pilotId);
		if (pilot != null) {
			responseStructure.setMessage("Sucessfully pilot deleted from  Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(pilotDao.deletePilotById(pilotId));
			return responseStructure;
		} else
			throw new PilotIdNotFound();
	}

	public ResponseStructure<Pilot> updatePilotById(int oldPilotId, Pilot newPilot) {
		Pilot pilot = pilotDao.fetchPilotById(oldPilotId);
		if (pilot != null) {
			responseStructure.setMessage("Sucessfully pilot updated inside Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(pilotDao.updatePilotById(oldPilotId, newPilot));
			return responseStructure;
		} else
			throw new PilotIdNotFound();
	}
}
