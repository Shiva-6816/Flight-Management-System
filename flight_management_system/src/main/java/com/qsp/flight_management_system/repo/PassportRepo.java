package com.qsp.flight_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.flight_management_system.dto.Passport;

public interface PassportRepo extends JpaRepository<Passport, Integer>{

}
