package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.SeatDao;
import com.qsp.flight_management_system.dto.Seat;
import com.qsp.flight_management_system.exception.SeatIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class SeatService {

	@Autowired
	SeatDao seatDao;

	@Autowired
	ResponseStructure<Seat> responseStructure;

	@Autowired
	ResponseStructureList<Seat> responseStructureList;

	public ResponseStructure<Seat> saveSeat(Seat seat) {
		responseStructure.setMessage("Sucessfully Seat added inside Database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(seatDao.saveSeat(seat));
		return responseStructure;
	}

	public ResponseStructure<Seat> fetchSeatById(int seatId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		if (seat != null) {
			responseStructure.setMessage("Sucessfully Seat fetched from Database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(seatDao.fetchSeatById(seatId));
			return responseStructure;
		} else
			throw new SeatIdNotFound();
	}

	public ResponseStructureList<Seat> fetchAllSeat() {
		responseStructureList.setMessage("Sucessfully fetched All the Seats from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(seatDao.fetchAllSeat());
		return responseStructureList;
	}

	public ResponseStructure<Seat> deleteSeatById(int seatId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		if (seat != null) {
			responseStructure.setMessage("Sucessfully Seat deleted from Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(seatDao.deleteSeatById(seatId));
			return responseStructure;
		} else
			throw new SeatIdNotFound();
	}

	public ResponseStructure<Seat> updateSeatById(int oldSeatId, Seat newsSeat) {
		Seat seat = seatDao.fetchSeatById(oldSeatId);
		if (seat != null) {
			responseStructure.setMessage("Sucessfully Seat updated inside Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(seatDao.updateSeatById(oldSeatId, newsSeat));
			return responseStructure;
		} else
			throw new SeatIdNotFound();
	}
}
