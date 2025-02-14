package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Seat;
import com.qsp.flight_management_system.repo.SeatRepo;

@Repository
public class SeatDao {

	@Autowired
	SeatRepo seatRepo;

	public Seat saveSeat(Seat seat) {
		return seatRepo.save(seat);
	}

	public Seat fetchSeatById(int seatId) {
		Optional<Seat> seat = seatRepo.findById(seatId);
		if (seat.isPresent())
			return seat.get();
		else
			return null;
	}

	public List<Seat> fetchAllSeat() {
		return seatRepo.findAll();
	}

	public Seat deleteSeatById(int seatId) {
		Seat seat = fetchSeatById(seatId);
		if (seat != null) {
			seatRepo.delete(seat);
			return seat;
		} else
			return null;
	}

	public Seat updateSeatById(int oldSeatId, Seat newsSeat) {
		Seat seat = fetchSeatById(oldSeatId);
		if (seat != null) {
			newsSeat.setSeatId(oldSeatId);
			return seatRepo.save(newsSeat);
		} else
			return null;
	}

}
