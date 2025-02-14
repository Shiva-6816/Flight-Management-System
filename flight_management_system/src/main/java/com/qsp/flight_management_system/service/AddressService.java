package com.qsp.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.flight_management_system.dao.AddressDao;
import com.qsp.flight_management_system.dto.Address;
import com.qsp.flight_management_system.exception.AddressIdNotFound;
import com.qsp.flight_management_system.util.ResponseStructure;
import com.qsp.flight_management_system.util.ResponseStructureList;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructureList<Address> responseStructureList;

	@Autowired
	ResponseStructure<Address> responseStructure; // ResponseStructure is used to print the message and status code of
													// the operation
 
	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setMessage("Sucessfully Address Saved in DataBase");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}

	public ResponseStructure<Address> fetchAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("Sucessfully Fetched the Address from  DataBase");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(addressDao.fetchAddressById(addressId));
			return responseStructure;
		} else
			throw new AddressIdNotFound();
	}

	public ResponseStructureList<Address> fetchAllAddresses() {
		responseStructureList.setMessage("Sucessfully fetched All the Address from the Database");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(addressDao.fetchAllAddress());
		return responseStructureList;

	}

	public ResponseStructure<Address> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setMessage("Sucessfully Address Deleted inside the DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return responseStructure;
		} else
			throw new AddressIdNotFound();

	}

	public ResponseStructure<Address> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressDao.fetchAddressById(oldAddressId);
		if (address != null) {
			responseStructure.setMessage("Sucessfully Address Updated in to  DataBase");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			return responseStructure;
		} else
			throw new AddressIdNotFound();

	}
}
