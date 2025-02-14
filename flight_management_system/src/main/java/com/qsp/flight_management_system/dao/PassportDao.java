package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Passport;
import com.qsp.flight_management_system.repo.PassportRepo;

@Repository
public class PassportDao {

	@Autowired
	PassportRepo passportRepo;

	public Passport savePassport(Passport passport) {
		return passportRepo.save(passport);
	}

	public Passport fetchPassportById(int passportId) {
		Optional<Passport> passport = passportRepo.findById(passportId);
		if (passport.isPresent())
			return passport.get();
		else
			return null;
	}

	public List<Passport> fetchAllPassport() {
		return passportRepo.findAll();
	}

	public Passport deletePassportById(int passportId) {
		Passport passport = fetchPassportById(passportId);
		if (passport != null) {
			passportRepo.delete(passport);
			return passport;
		} else
			return null;
	}

	public Passport updatePassportById(int oldPassportId, Passport newPassport) {
		Passport passport = fetchPassportById(oldPassportId);
		if (passport != null) {
			newPassport.setPassportId(oldPassportId);
			return passportRepo.save(newPassport);
		} else
			return null;
	}
}
