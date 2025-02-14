package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.PassportDao;
import com.qsp.flight_management_system.dto.Passport;
import com.qsp.flight_management_system.exception.PassportIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class PassportService {

	@Autowired
	PassportDao passportDao;

	@Autowired
	ResponseStructure<Passport> responseStructure;

	@Autowired
	ResponseStructureList<Passport> responseStructureList;

	public ResponseStructure<Passport> savePassport(Passport passport) {
		responseStructure.setMessage("Sucessfully passport added inside Database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(passportDao.savePassport(passport));
		return responseStructure;
	}

	public ResponseStructure<Passport> fetchPassportById(int passportId) {
		Passport passport = passportDao.fetchPassportById(passportId);
		if (passport != null) {
			responseStructure.setMessage("Sucessfully passport fetched from  Database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(passportDao.fetchPassportById(passportId));
			return responseStructure;
		} else
			throw new PassportIdNotFound();
	}

	public ResponseStructureList<Passport> fetchAllPassport() {
		responseStructureList.setMessage("Sucessfully fetched All the passports from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(passportDao.fetchAllPassport());
		return responseStructureList;
	}

	public ResponseStructure<Passport> deletePassportById(int passportId) {
		Passport passport = passportDao.fetchPassportById(passportId);
		if (passport != null) {
			responseStructure.setMessage("Sucessfully passport deleted from  Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passportDao.deletePassportById(passportId));
			return responseStructure;
		} else
			throw new PassportIdNotFound();
	}

	public ResponseStructure<Passport> updatePassportById(int oldPassportId, Passport newPassport) {
		Passport passport = passportDao.fetchPassportById(oldPassportId);
		if (passport != null) {
			responseStructure.setMessage("Sucessfully passport Updated inside the  Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passportDao.updatePassportById(oldPassportId, newPassport));
			return responseStructure;
		} else
			throw new PassportIdNotFound();
	}
}
