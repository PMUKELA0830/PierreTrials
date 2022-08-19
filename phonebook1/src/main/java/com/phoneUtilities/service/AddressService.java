package com.phoneUtilities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneUtilities.entity.Address;
import com.phoneUtilities.repo.AddressRepo;

@Service
public class AddressService {
	
	
	Address address;
	@Autowired
	AddressRepo addressRepo;
	
	
	public void saveAddress(Address address) {
		addressRepo.save(address);
	}
	
	public void deleteAddress(Address address) {
		addressRepo.delete(address);
	}
	
	public String editAddress(String address) {
		addressRepo.findByStreetName(address);
		return address;
	}
	
	public void deleteAll(Address address) {
		addressRepo.deleteAll();
	}
}
