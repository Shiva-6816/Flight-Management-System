package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Payment;
import com.qsp.flight_management_system.repo.PaymentRepo;

@Repository
public class PaymentDao {

	@Autowired
	PaymentRepo paymentRepo;

	public Payment savePayment(Payment Payment) {
		return paymentRepo.save(Payment);
	}

	public Payment fetchPaymentById(int paymentId) {
		Optional<Payment> payment = paymentRepo.findById(paymentId);
		if (payment.isPresent())
			return payment.get();
		else
			return null;
	}

	public List<Payment> fetchAllPayment() {
		return paymentRepo.findAll();
	}

	public Payment deletePaymentById(int paymentId) {
		Payment payment = fetchPaymentById(paymentId);
		if (payment != null) {
			paymentRepo.delete(payment);
			return payment;
		} else
			return null;
	}

	public Payment updatePaymentById(int oldPaymentId, Payment newPayment) {
		Payment payment = fetchPaymentById(oldPaymentId);
		if (payment != null) {
			newPayment.setPaymentId(oldPaymentId);
			return paymentRepo.save(newPayment);
		} else
			return null;

	}

}
