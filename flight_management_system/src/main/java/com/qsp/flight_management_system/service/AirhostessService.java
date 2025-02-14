package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.AirhostessDao;
import com.qsp.flight_management_system.dto.Airhostess;
import com.qsp.flight_management_system.exception.AirhostessIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class AirhostessService {

	@Autowired
	AirhostessDao airhostessDao;

	@Autowired
	ResponseStructure<Airhostess> responseStructure;

	@Autowired
	ResponseStructureList<Airhostess> responseStructureList;

	public ResponseStructure<Airhostess> saveAirhostess(Airhostess airhostess) {
		responseStructure.setMessage("Sucessfully Airhostess Saved inside the DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(airhostessDao.saveAirhostess(airhostess));
		return responseStructure;
	}

	public ResponseStructure<Airhostess> fetchAirhostessById(int airhostessId) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Sucessfully Airhostess Fetched from the DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airhostessDao.fetchAirhostessById(airhostessId));
			return responseStructure;
		} else
			throw new AirhostessIdNotFound();
	}

	public ResponseStructureList<Airhostess> fetchAllAirhostess() {
		responseStructureList.setMessage("Sucessfully fetched All the AirHostess from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(airhostessDao.fetchAllAirhostess());
		return responseStructureList;

	}

	public ResponseStructure<Airhostess> deleteAirhostessById(int airhostessId) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(airhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Sucessfully Airhostess Fetched from the DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.deleteAirhostessById(airhostessId));
			return responseStructure;
		} else
			throw new AirhostessIdNotFound();
	}

	public ResponseStructure<Airhostess> updateAirhostessById(int oldAirhostessId, Airhostess newAirhostess) {
		Airhostess airhostess = airhostessDao.fetchAirhostessById(oldAirhostessId);
		if (airhostess != null) {
			responseStructure.setMessage("Sucessfully Airhostess Updated to DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airhostessDao.updateAirhostessById(oldAirhostessId, newAirhostess));
			return responseStructure;
		} else
			throw new AirhostessIdNotFound();
	}
}
