package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Payment;
import com.qsp.flight_management_system.dto.Ticket;
import com.qsp.flight_management_system.repo.TicketRepo;

@Repository
public class TicketDao {

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	PaymentDao paymentDao;

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public Ticket fetchTicketById(int ticketId) {
		Optional<Ticket> ticket = ticketRepo.findById(ticketId);
		if (ticket.isPresent())
			return ticket.get();
		else
			return null;
	}

	public List<Ticket> fetchAllTicket() {
		return ticketRepo.findAll();
	}

	public Ticket deleteTicketById(int ticketId) {
		Ticket ticket = fetchTicketById(ticketId);
		if (ticket != null) {
			ticketRepo.delete(ticket);
			return ticket;
		} else
			return null;
	}

	public Ticket updateTicketById(int oldTickeId, Ticket newTicket) {
		Ticket ticket = fetchTicketById(oldTickeId);
		if (ticket != null) {
			newTicket.setTicketId(oldTickeId);
			return ticketRepo.save(newTicket);
		} else
			return null;
	}

	// one to one mapping
	public Ticket addExisistingTicketToExisstingPayment(int ticketId, int paymentId) {
		Ticket ticket = fetchTicketById(ticketId);
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		ticket.setPayment(payment);

		return ticketRepo.save(ticket);

	}
}
