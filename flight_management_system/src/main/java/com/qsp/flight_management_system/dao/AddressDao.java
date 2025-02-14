package com.qsp.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.flight_management_system.dto.Address;
import com.qsp.flight_management_system.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public Address fetchAddressById(int addressId) {
		Optional<Address> address = addressRepo.findById(addressId);
		if (address.isPresent())
			return address.get();
		else
			return null;
	}

	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}

	public Address deleteAddressById(int addressId) {
		Address address = fetchAddressById(addressId);
		if (address != null) {
			addressRepo.delete(address);
			return address;
		} else
			return null;
	}

	public Address updateAddressById(int oldAddressId, Address newAddress) {
		Optional<Address> address = addressRepo.findById(oldAddressId);
		if (address.isPresent()) {
			newAddress.setAddressId(oldAddressId);
			addressRepo.save(newAddress);
			return address.get();
		} else
			return null;

	}
}
