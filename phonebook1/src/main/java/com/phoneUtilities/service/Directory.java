package com.phoneUtilities.service;

import java.util.ArrayList;

import java.util.List;

//import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.phoneUtilities.entity.Address;
import com.phoneUtilities.entity.Person;
import com.phoneUtilities.repo.PersonRepo;

@Service
public class Directory {

@Autowired
PersonService personService;
Person[] person = new Person[0];
@Autowired
PersonRepo[] personRepo;
List<Person> perso = new ArrayList<Person>();

	public void addPerson(Person newPerson) {
		
		Person[] temp = new Person[person.length + 1];
		
		for (int i = 0; i < person.length; i++) {
			temp[i] = person[i];
			
		}
		
		temp[temp.length - 1] = newPerson;
		
		person = temp;
	}
	
	// Review this in case of error
	public Person[] getDirectory() {
		return person;
	}
	
	public void printDirectory() {
		for(int i = 0; i < person.length; i++) {
			person[i].getPerson();
		}
	}
	
	public void printSortedDirectory(Person sorted) {
		for(int i = 0; i < person.length; i++) {
			person[i].getPerson();
		}
	}
	
	public void printDirectoryArray(Person[] searched) {
		for(int i = 0; i < searched.length; i++) {
			searched[i].getPerson();
		}
	}
	
	
	// Showing the list of contacts in an alphabetical order
	// The method below works only for internally saved data
	// not with external data sources like MySQL
	
	public List<Person> sortingContactsAlph() {
		Person[] sortContactList = getDirectory();
		Person tempContact = sortContactList[0];
		List<Person> listSortedContact = new ArrayList<Person>();
		for (int i = 0; i < sortContactList.length; i++) {
			for (int j = i+1; j < sortContactList.length; j++) {
				if(sortContactList[i].getFirstName().compareTo(sortContactList[j].getFirstName())> 0) {
				tempContact = sortContactList[i];
				sortContactList[i] = sortContactList[j];
				sortContactList[j] = tempContact;
				
				//sortContactList = tempContact;
				
				}
				tempContact = sortContactList[i];
				listSortedContact.add(tempContact);
			}
		}
		return listSortedContact;
	}
	
	
	
	
	//Search methods
	//Search by firstName
	
	public Person[] searchByFirstName(String firstnameKeyword) {
		int counter = 0;
		for (int i = 0; i < person.length; i++) {
			if(person[i].getFirstName().equalsIgnoreCase(firstnameKeyword)) {
				counter++;
			}
		}
		//New array to hold contacts found in the directory
		Person[] tempArray = new Person[counter];
		
		//Populate the results
		int tempCounter = 0;
		
		for (int i = 0; i < person.length; i++) {
			if (person[i].getFirstName().equalsIgnoreCase(firstnameKeyword)) {
			tempArray[tempCounter] = person[i];
			tempCounter++;
			}
		}
		return tempArray;
	}
	
	// Search by last name
	
	public Person[] searchByLastName(String lastnameKeyword) {
		int counter = 0;
		for (int i = 0; i < person.length; i++) {
			if(person[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
				counter++;
			}
		}
		//New array to hold contacts found in the directory
		Person[] tempArray1 = new Person[counter];
		
		//Populate the results
		int tempCounter1 = 0;
		
		for (int i = 0; i < person.length; i++) {
			if (person[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
			tempArray1[tempCounter1] = person[i];
			tempCounter1++;
			}
		}
		return tempArray1;
	}
	
	// Search by full name
	
	public Person[] searchByFullName(String firstnameKeyword, String lastnameKeyword) {
		int counter = 0;
		for (int i = 0; i < person.length; i++) {
			if(person[i].getFirstName().equalsIgnoreCase(firstnameKeyword) &&
					person[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
				counter++;
			}
		}
		//New array to hold contacts found in the directory
		Person[] tempArray2 = new Person[counter];
		
		//Populate the results
		int tempCounter1 = 0;
		
		for (int i = 0; i < person.length; i++) {
			if (person[i].getFirstName().equalsIgnoreCase(firstnameKeyword) &&
					person[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
			tempArray2[tempCounter1] = person[i];
			tempCounter1++;
			}
		}
		return tempArray2;
	}
	
	//Search by phone number
	
	public Person[] searchByPhoneNumber(String phoneNum) {
		int counter = 0;
		for (int i = 0; i < person.length; i++) {
			if((person[i].getPhoneNumber()).equals(phoneNum)) {
				counter++;
			}
		}
		//New array to hold contacts found in the directory
		Person[] tempPhoneNum = new Person[counter];
		
		//Populate the results
		int tempCounter1 = 0;
		
		for (int i = 0; i < person.length; i++) {
			
			if ((person[i].getPhoneNumber()).equals(phoneNum)) {
			tempPhoneNum[tempCounter1] = person[i];
			tempCounter1++;
				}
		}
		return tempPhoneNum;
	}
	
	// Search by city or state
	
	public Person[] searchByCityOrState(String cityOrStateKeyword) {
		//Address address = new Address();
		int counter = 0;
		
		for (int i = 0; i < person.length; i++) {
			String contactAddress = person[i].getAddress();
			String[] contactAddrArr = contactAddress.split(", ");
			for (int j = 0; j < contactAddrArr.length; j++) {
				if(contactAddrArr[i].equalsIgnoreCase(cityOrStateKeyword)) {
					counter++;
				}
			}
//			if(person[i].getAddress().getCity().equalsIgnoreCase(cityOrStateKeyword) 
//			|| person[i].getAddress().getState().equalsIgnoreCase(cityOrStateKeyword)) {
//			counter++;
//			}
		}
		//New array to hold contacts found in the directory
		Person[] tempArray3 = new Person[counter];
		
		//Populate the results
		int tempCounter1 = 0;
		
		for (int i = 0; i < person.length; i++) {
			
			String contactAddress = person[i].getAddress();
			String[] contactAddrArr = contactAddress.split(", ");
			for (int j = 0; j < contactAddrArr.length; j++) {
				if(contactAddrArr[i].equalsIgnoreCase(cityOrStateKeyword)) {
					tempArray3[tempCounter1] = person[i];
					tempCounter1++;
				}
			}
			
//			if (person[i].getAddress().getCity().equalsIgnoreCase(cityOrStateKeyword) 
//				|| person[i].getAddress().getState().equalsIgnoreCase(cityOrStateKeyword)) {
//			tempArray3[tempCounter1] = person[i];
//			tempCounter1++;
//				}	
		}
		return tempArray3;
	}
	
	//Creating a new contact and adding it to the contact list of the phone book.
	
	public Person createContact(String firstName, 
								String middleName, 
								String lastName, 
								String phoneNumber,
								int streetNumber, 
								String streetName,
								String streetType, 
								String city, 
								String state,
								long zipCode) {
		//Directory contactList = new Directory();
		
		Person person = new Person();
		if (middleName.length() == 0) {
			person = new Person(firstName, lastName, phoneNumber);
			person.addAddress(streetNumber, streetName, streetType, city, state, zipCode);
			this.addPerson(person);
		} else {
			person = new Person(firstName, middleName, lastName, phoneNumber);
			person.addAddress(streetNumber, streetName, streetType, city, state, zipCode);
			this.addPerson(person);
		}
	
	// This is to add or save the contact in the Contact list
	
	//Display all contacts
	this.printDirectory();
	
	return person;
	}
	
	// Deleting an existing contact
	
		public Person[] deletePerson(String removed) {
			Person[] personRemove = searchByPhoneNumber(removed);
			//removed = Person.getPerson();
					
			//creates a temporary contact list one smaller than the current one
			Person[] temp = new Person[person.length - 1];
			//sets a counter integer for the temp array
			int x = 0;
			//loops through and adds everything except the person to be removed to the temp array
			for(int i = 0; i < person.length; i++) {
				
				if(person[i] != personRemove[0]) {
					temp[x] = person[i];
					x++;
				}
			}
			//sets the current array to equal the temporary array
			person = temp;
			
			return person;
			
		}
		
		
		
		
		
		
		
		
		
		
	
}
