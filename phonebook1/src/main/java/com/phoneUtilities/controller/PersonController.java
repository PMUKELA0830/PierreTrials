package com.phoneUtilities.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoneUtilities.entity.Address;
import com.phoneUtilities.entity.Person;
import com.phoneUtilities.entity.PersonFavorite;
import com.phoneUtilities.repo.AddressRepo;
import com.phoneUtilities.repo.PersonFavoriteRepo;
import com.phoneUtilities.repo.PersonRepo;
import com.phoneUtilities.service.AddressService;
import com.phoneUtilities.service.Directory;
import com.phoneUtilities.service.DirectoryFavorite;
import com.phoneUtilities.service.PersonFavoriteService;
import com.phoneUtilities.service.PersonService;

@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {
	
	Person[] person = new Person[0];
	
	@Autowired
	PersonService personService;
	
	@Autowired
	PersonFavoriteService personFavoriteService;
	
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	PersonFavoriteRepo personFavoriteRepo;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	Directory directory;
	
	@Autowired
	DirectoryFavorite directoryFavorite;
	
	
	// Get the person info and save it to the database
	
	@RequestMapping(value = "/getPersonInfo", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public void submitProductDetail(@RequestBody Person person) {
		
		personService.savePerson(person);
		
	}
	
	
	// 1. This is to create and add a new contact to the phonebook
	
	@RequestMapping(value = "/addPersonContact", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Person> createNewContact(@RequestParam ("firstName") String firstName, 
												   @RequestParam ("middleName") String middleName, 
												   @RequestParam ("lastName") String lastName, 
												   @RequestParam ("phoneNumber") String phoneNumber,
												   @RequestParam ("streetNumber") int streetNumber,
												   @RequestParam ("streetName") String streetName,
												   @RequestParam ("streetType") String streetType,
												   @RequestParam ("city") String city,
												   @RequestParam ("state") String state,
												   @RequestParam ("zipCode") long zipCode) {
				// FlooringProduct flooringProduct = new FlooringProduct();
				Person tempPers = new Person();
				
				// Add and save address to the database
				Address address = new Address(streetNumber,
											  streetName,
											  streetType,
											  city,
											  state,
											  zipCode);
				addressService.saveAddress(address);
		try {
			tempPers = directory.createContact(firstName, 
											   middleName, 
											   lastName, 
											   phoneNumber, 
											   streetNumber, 
											   streetName, 
											   streetType, 
											   city, 
											   state, 
											   zipCode);
			personService.savePerson(tempPers);
			return new ResponseEntity<Person>(tempPers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	// Searching for a contact in different ways
	
	// 2. By phoneNumber
	
	@RequestMapping(value = "/findByPhoneNumber", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Optional<Person>> findByPhoneNumber(@RequestParam ("phoneNumber") String phoneNumber){
		
		try {
				personRepo.findById(phoneNumber);
				Optional<Person> pers = Optional.of(new Person());

				pers = personRepo.findById(phoneNumber);
			return new ResponseEntity<Optional<Person>>(pers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<Optional<Person>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	// 3. By firstName
	
	@RequestMapping(value = "/findByFirstName", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<Person>> findByFirstName(@RequestParam ("firstName") String firstName){
		
		try {
				personRepo.findByFirstName(firstName);
				List<Person> pers = new ArrayList<Person>();

				pers = personRepo.findByFirstName(firstName);
			return new ResponseEntity<List<Person>>(pers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	// 4. By city or state
	
	@RequestMapping(value = "/findByCityOrState", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<Person>> findByCityOrState(@RequestParam ("keyword") String keyword){
		
		try {
				personRepo.findByCityOrState(keyword);
				List<Person> pers = new ArrayList<Person>();

				pers = personRepo.findByCityOrState(keyword);
			return new ResponseEntity<List<Person>>(pers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	// 5. Find contact by entering any keyword as long as it is part of their saved information
	
	@RequestMapping(value = "/findPersonContact", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<Person>> findPersonContact(@RequestParam ("keyword") String keyword){
		
		try {
				personRepo.findPersonContact(keyword);
				List<Person> pers = new ArrayList<Person>();

				pers = personRepo.findPersonContact(keyword);
			return new ResponseEntity<List<Person>>(pers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	// 6. Find contact by full name
	
	@RequestMapping(value = "/findByFullName", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<Person>> findByFullName(@RequestParam ("firstName") String firstName, 
														   @RequestParam ("lastName") String lastName){
		
		try {
				personRepo.findByFullName(firstName, lastName);
				List<Person> pers = new ArrayList<Person>();

				pers = personRepo.findByFullName(firstName, lastName);
			return new ResponseEntity<List<Person>>(pers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	// 7. Show all saved contacts
	
	@RequestMapping(value = "/findAll", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<Person>> findAll(){
		
		try {
				personRepo.findAll();
				List<Person> pers = new ArrayList<Person>();

				pers = personRepo.findAll();
			return new ResponseEntity<List<Person>>(pers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	// 8. Sorting method defined here
	public static List<Person> sort(List<Person> list) {
		  
        list.sort((person1, person2)
                  -> person1.getPerson().compareTo(
                      person2.getPerson()));
        
        return list;
    }
	
	
	// 8. Sorting Contacts in an alphabetical order
	
	@RequestMapping(value = "/sortAlphaOrder", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<List<Person>> sortAlphaOrder(){
		
		//try {
				List<Person> pers = new ArrayList<Person>();
				//List<Person> persSorted = new ArrayList<Person>();
				pers = personRepo.findAll();
				//persSorted = sort(pers);
			return new ResponseEntity<List<Person>>(pers, HttpStatus.OK);
			
	//	} catch(Exception e) {
	//		return new ResponseEntity<List<Person>>(HttpStatus.BAD_REQUEST);
		//}
		
	}
	
	
	
	
	
//	@RequestMapping(value = "/updateContact", consumes = MediaType.APPLICATION_JSON_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	public ResponseEntity<Optional<Person>> updateContact(@RequestParam ("firstName")String firstName, 
//														  @RequestParam ("middleName") String middleName, 
//														  @RequestParam ("lastName")String lastName,
//														  @RequestParam ("phoneNumber")String phoneNumber,
//														  @RequestParam ("phoneNum")String phoneNum){
//		
//		try {
//				personRepo.updateContact(firstName, middleName, lastName, phoneNumber, phoneNum);
//				Optional<Person> pers = Optional.of(new Person());
//
//				pers = personRepo.updateContact(firstName, middleName, lastName, phoneNumber, phoneNum);
//			return new ResponseEntity<Optional<Person>>(pers, HttpStatus.OK);
//			
//		} catch(Exception e) {
//			return new ResponseEntity<Optional<Person>>(HttpStatus.BAD_REQUEST);
//		}
//		
//	}
	
	
	
	// 9. Updating an existing contact
	@RequestMapping(value = "/updateContact", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Person> updateContact(@RequestParam ("firstName") String firstName, 
							  @RequestParam ("middleName") String middleName, 
							  @RequestParam ("lastName") String lastName, 
							  @RequestParam ("phoneNumber") String phoneNumber,
							  @RequestParam ("streetNumber") int streetNumber, 
							  @RequestParam ("streetName") String streetName,
							  @RequestParam ("streetType") String streetType, 
							  @RequestParam ("city") String city, 
							  @RequestParam ("state") String state,
							  @RequestParam ("zipCode") long zipCode) {
		
		
		
		try {
			Person person = new Person();
			person = personRepo.findByPhoneNumber(phoneNumber);
			person.setFirstName(firstName);
			person.setMiddleName(middleName);
			person.setLastName(lastName);
			person.addAddress(streetNumber, streetName, streetType, city, state, zipCode);
			personService.savePerson(person);
					
				return new ResponseEntity<Person>(person, HttpStatus.OK);
				
			} catch(Exception e) {
				return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
			}
		
		}
	
	
	// 10. Adding a contact to the favorite list
	
	@RequestMapping(value = "/addContactToFavorite", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Person> addContactToFavorite(@RequestParam ("phoneNumber") String phoneNumber){
		
		//try {
			
			
			// Search for a contact in Person table
				Person pers = new Person();
				pers = personRepo.findByPhoneNumber(phoneNumber);
			// Save the contact found in the PersonFavorite table
			
				
				PersonFavorite personFav = new PersonFavorite();
				String firstName = personRepo.getFirstName(phoneNumber);
				String middleName = personRepo.getMiddleName(phoneNumber);
				String lastName = personRepo.getLastName(phoneNumber);
				String phoneNum = personRepo.getPhoneNumber(phoneNumber); 
				String address = personRepo.getAddress(phoneNumber);
				
				
				personFav = directoryFavorite.createContact(firstName,
															middleName,
															lastName,
															phoneNum,
															address);
						
				
				personFavoriteService.savePerson(personFav);
				
			return new ResponseEntity<Person>(pers, HttpStatus.OK);
			
		//} catch(Exception e) {
		//	return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
		//}
		
	}
	
	
	
	// 11. Deleting an existing contact
	
	@RequestMapping(value = "/deleteContact", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void deleteContact(@RequestParam ("phoneNumber") String phoneNumber){
		
		personRepo.deleteById(phoneNumber);
		
	}
	
		
	
	
	
	
	
}
