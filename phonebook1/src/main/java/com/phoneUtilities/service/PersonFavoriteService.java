package com.phoneUtilities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneUtilities.entity.Address;
import com.phoneUtilities.entity.Person;
import com.phoneUtilities.entity.PersonFavorite;
import com.phoneUtilities.repo.PersonRepo;


@Service
public class PersonFavoriteService {
	
	
	Person person;
	Address address;
	PersonFavorite personFavorite;
	
	@Autowired
	PersonRepo personRepo;
	AddressService addressService;
	
	@Autowired
	PersonRepo personFavoriteRepo;

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
	
	
	public void savePerson(PersonFavorite personFavorite) {
		personFavoriteRepo.save(person);
	}
	
	public String findPerson(String person) {
		personFavoriteRepo.findById(person);
		return person;
	}
	
	
	public void deletePerson(Person person) {
		personFavoriteRepo.delete(person);
	}
	
	public void deleteAll(Person person) {
		personFavoriteRepo.deleteAll();
	}
}
