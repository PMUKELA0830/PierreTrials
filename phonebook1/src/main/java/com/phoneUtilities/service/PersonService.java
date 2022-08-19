package com.phoneUtilities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneUtilities.entity.Address;
import com.phoneUtilities.entity.Person;
import com.phoneUtilities.repo.PersonRepo;

@Service
public class PersonService {
	
	Person person;
	Address address;
	
	@Autowired
	PersonRepo personRepo;
	AddressService addressService;

//	public void addAddress(int streetNumber, 
//						   String streetName, 
//						   String streetType, 
//						   String city, 
//						   String state, 
//						   long zipCode) {
//		Address tempAddress = new Address(streetNumber, 
//										  streetName, 
//										  city, 
//										  state, 
//										  zipCode);
//		address = tempAddress;
//
//	}
	
	
	public void savePerson(Person person) {
		personRepo.save(person);
	}
	
	public String findPerson(String person) {
		personRepo.findById(person);
		return person;
	}
	
	
	public void deletePerson(Person person) {
		personRepo.delete(person);
	}
	
	public void deleteAll(Person person) {
		personRepo.deleteAll();
	}
	
}
