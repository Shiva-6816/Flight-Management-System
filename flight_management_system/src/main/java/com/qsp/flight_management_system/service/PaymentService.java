package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.PaymentDao;
import com.qsp.flight_management_system.dto.Payment;
import com.qsp.flight_management_system.exception.PaymentIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	ResponseStructure<Payment> responseStructure;

	@Autowired
	ResponseStructureList<Payment> responseStructureList;

	public ResponseStructure<Payment> savePayment(Payment Payment) {
		responseStructure.setMessage("Sucessfully payment added in Database");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(paymentDao.savePayment(Payment));
		return responseStructure;
	}

	public ResponseStructure<Payment> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setMessage("Sucessfully fetched payment from Database");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return responseStructure;
		} else
			throw new PaymentIdNotFound();
	}

	public ResponseStructureList<Payment> fetchAllPayment() {
		responseStructureList.setMessage("Sucessfully fetched All the payment from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(paymentDao.fetchAllPayment());
		return responseStructureList;
	}

	public ResponseStructure<Payment> deletePaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setMessage("Sucessfully deleted payment from Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(paymentDao.deletePaymentById(paymentId));
			return responseStructure;
		} else
			throw new PaymentIdNotFound();
	}

	public ResponseStructure<Payment> updatePaymentById(int oldPaymentId, Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldPaymentId);
		if (payment != null) {
			responseStructure.setMessage("Sucessfully Updated payment in Database");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(paymentDao.updatePaymentById(oldPaymentId, newPayment));
			return responseStructure;
		} else
			throw new PaymentIdNotFound();

	}
}
