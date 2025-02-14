package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.PaymentDao;
import com.qsp.flight_management_system.dao.TicketDao;
import com.qsp.flight_management_system.dto.Payment;
import com.qsp.flight_management_system.dto.Ticket;
import com.qsp.flight_management_system.exception.PaymentIdNotFound;
import com.qsp.flight_management_system.exception.TicketIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Ticket> responseStructure;

	@Autowired
	ResponseStructureList<Ticket> responseStructureList;

	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setMessage("Sucessfully Ticket added inside Database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;
	}

	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			responseStructure.setMessage("Sucessfully Ticket fetched from Database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(ticketDao.fetchTicketById(ticketId));
			return responseStructure;
		} else
			throw new TicketIdNotFound();
	}

	public ResponseStructureList<Ticket> fetchAllTicket() {
		responseStructureList.setMessage("Sucessfully fetched All the Tickets from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(ticketDao.fetchAllTicket());
		return responseStructureList;
	}

	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			responseStructure.setMessage("Sucessfully Ticket deleted inside Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ticketDao.deleteTicketById(ticketId));
			return responseStructure;
		} else
			throw new TicketIdNotFound();
	}

	public ResponseStructure<Ticket> updateTicketById(int oldTickeId, Ticket newTicket) {
		Ticket ticket = ticketDao.fetchTicketById(oldTickeId);
		if (ticket != null) {
			responseStructure.setMessage("Sucessfully Ticket updated inside Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(ticketDao.updateTicketById(oldTickeId, newTicket));
			return responseStructure;
		} else
			throw new TicketIdNotFound();
	}

	// one to one mapping
	public ResponseStructure<Ticket> addExisistingTicketToExisstingPayment(int ticketId, int paymentId) {
		Ticket ticket = ticketDao.fetchTicketById(ticketId);
		if (ticket != null) {
			Payment payment = paymentDao.fetchPaymentById(paymentId);
			if (payment != null) {
				responseStructure.setMessage("Sucessfully mapped Exisisting Ticket To Exissting Payment Database");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(ticketDao.addExisistingTicketToExisstingPayment(ticketId, paymentId));
				return responseStructure;
			} else
				throw new PaymentIdNotFound(); 
		} else
			throw new TicketIdNotFound();
	}

}
