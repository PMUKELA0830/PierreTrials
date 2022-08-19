package com.phoneUtilities.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoneUtilities.entity.Person;
import com.phoneUtilities.entity.PersonFavorite;
import com.phoneUtilities.repo.PersonFavoriteRepo;

@Service
public class DirectoryFavorite {
	
	@Autowired
	PersonFavoriteService personFavoriteService;
	PersonFavorite[] personFavorite = new PersonFavorite[0];
	@Autowired
	PersonFavoriteRepo[] personFavoriteRepo;
	List<PersonFavorite> persoFavorite = new ArrayList<PersonFavorite>();

		public void addPerson(PersonFavorite newPersonFavorite) {
			
			PersonFavorite[] temp = new PersonFavorite[personFavorite.length + 1];
			
			for (int i = 0; i < personFavorite.length; i++) {
				temp[i] = personFavorite[i];
				
			}
			
			temp[temp.length - 1] = newPersonFavorite;
			
			personFavorite = temp;
		}
		
		// Review this in case of error
		public PersonFavorite[] getDirectoryFavorite() {
			return personFavorite;
		}
		
		public void printDirectoryFavorite() {
			for(int i = 0; i < personFavorite.length; i++) {
				personFavorite[i].getPersonFavorite();
			}
		}
		
		public void printSortedDirectory(PersonFavorite sorted) {
			for(int i = 0; i < personFavorite.length; i++) {
				personFavorite[i].getPersonFavorite();
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
		
		public List<PersonFavorite> sortingContactsAlph() {
			PersonFavorite[] sortContactList = getDirectoryFavorite();
			PersonFavorite tempContact = sortContactList[0];
			List<PersonFavorite> listSortedContact = new ArrayList<PersonFavorite>();
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
		
		public PersonFavorite[] searchByFirstName(String firstnameKeyword) {
			int counter = 0;
			for (int i = 0; i < personFavorite.length; i++) {
				if(personFavorite[i].getFirstName().equalsIgnoreCase(firstnameKeyword)) {
					counter++;
				}
			}
			//New array to hold contacts found in the directory
			PersonFavorite[] tempArray = new PersonFavorite[counter];
			
			//Populate the results
			int tempCounter = 0;
			
			for (int i = 0; i < personFavorite.length; i++) {
				if (personFavorite[i].getFirstName().equalsIgnoreCase(firstnameKeyword)) {
				tempArray[tempCounter] = personFavorite[i];
				tempCounter++;
				}
			}
			return tempArray;
		}
		
		// Search by last name
		
		public PersonFavorite[] searchByLastName(String lastnameKeyword) {
			int counter = 0;
			for (int i = 0; i < personFavorite.length; i++) {
				if(personFavorite[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
					counter++;
				}
			}
			//New array to hold contacts found in the directory
			PersonFavorite[] tempArray1 = new PersonFavorite[counter];
			
			//Populate the results
			int tempCounter1 = 0;
			
			for (int i = 0; i < personFavorite.length; i++) {
				if (personFavorite[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
				tempArray1[tempCounter1] = personFavorite[i];
				tempCounter1++;
				}
			}
			return tempArray1;
		}
		
		// Search by full name
		
		public PersonFavorite[] searchByFullName(String firstnameKeyword, String lastnameKeyword) {
			int counter = 0;
			for (int i = 0; i < personFavorite.length; i++) {
				if(personFavorite[i].getFirstName().equalsIgnoreCase(firstnameKeyword) &&
						personFavorite[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
					counter++;
				}
			}
			//New array to hold contacts found in the directory
			PersonFavorite[] tempArray2 = new PersonFavorite[counter];
			
			//Populate the results
			int tempCounter1 = 0;
			
			for (int i = 0; i < personFavorite.length; i++) {
				if (personFavorite[i].getFirstName().equalsIgnoreCase(firstnameKeyword) &&
						personFavorite[i].getLastName().equalsIgnoreCase(lastnameKeyword)) {
				tempArray2[tempCounter1] = personFavorite[i];
				tempCounter1++;
				}
			}
			return tempArray2;
		}
		
		//Search by phone number
		
		public PersonFavorite[] searchByPhoneNumber(String phoneNum) {
			int counter = 0;
			for (int i = 0; i < personFavorite.length; i++) {
				if((personFavorite[i].getPhoneNumber()).equals(phoneNum)) {
					counter++;
				}
			}
			//New array to hold contacts found in the directory
			PersonFavorite[] tempPhoneNum = new PersonFavorite[counter];
			
			//Populate the results
			int tempCounter1 = 0;
			
			for (int i = 0; i < personFavorite.length; i++) {
				
				if ((personFavorite[i].getPhoneNumber()).equals(phoneNum)) {
				tempPhoneNum[tempCounter1] = personFavorite[i];
				tempCounter1++;
					}
			}
			return tempPhoneNum;
		}
		
		// Search by city or state
		
		public PersonFavorite[] searchByCityOrState(String cityOrStateKeyword) {
			//Address address = new Address();
			int counter = 0;
			
			for (int i = 0; i < personFavorite.length; i++) {
				String contactAddress = personFavorite[i].getAddress();
				String[] contactAddrArr = contactAddress.split(", ");
				for (int j = 0; j < contactAddrArr.length; j++) {
					if(contactAddrArr[i].equalsIgnoreCase(cityOrStateKeyword)) {
						counter++;
					}
				}
//				if(person[i].getAddress().getCity().equalsIgnoreCase(cityOrStateKeyword) 
//				|| person[i].getAddress().getState().equalsIgnoreCase(cityOrStateKeyword)) {
//				counter++;
//				}
			}
			//New array to hold contacts found in the directory
			PersonFavorite[] tempArray3 = new PersonFavorite[counter];
			
			//Populate the results
			int tempCounter1 = 0;
			
			for (int i = 0; i < personFavorite.length; i++) {
				
				String contactAddress = personFavorite[i].getAddress();
				String[] contactAddrArr = contactAddress.split(", ");
				for (int j = 0; j < contactAddrArr.length; j++) {
					if(contactAddrArr[i].equalsIgnoreCase(cityOrStateKeyword)) {
						tempArray3[tempCounter1] = personFavorite[i];
						tempCounter1++;
					}
				}
				
//				if (person[i].getAddress().getCity().equalsIgnoreCase(cityOrStateKeyword) 
//					|| person[i].getAddress().getState().equalsIgnoreCase(cityOrStateKeyword)) {
//				tempArray3[tempCounter1] = person[i];
//				tempCounter1++;
//					}	
			}
			return tempArray3;
		}
		
		//Creating a new contact and adding it to the contact list of the phone book.
		
		public PersonFavorite createContact(String firstName, 
									String middleName, 
									String lastName, 
									String phoneNumber, 
									String address) {
			//Directory contactList = new Directory();
			
			PersonFavorite personFavorite = new PersonFavorite();
			if (middleName.length() == 0) {
				personFavorite = new PersonFavorite(firstName, lastName, phoneNumber);
				personFavorite.setAddress(address);
				this.addPerson(personFavorite);
			} else {
				personFavorite = new PersonFavorite(firstName, middleName, lastName, phoneNumber);
				personFavorite.setAddress(address);
				this.addPerson(personFavorite);
			}
		
		// This is to add or save the contact in the Contact list
		
		//Display all contacts
		this.printDirectoryFavorite();
		
		return personFavorite;
		}
		
		// Deleting an existing contact
		
			public PersonFavorite[] deletePerson(String removed) {
				PersonFavorite[] personRemove = searchByPhoneNumber(removed);
				//removed = Person.getPerson();
						
				//creates a temporary contact list one smaller than the current one
				PersonFavorite[] temp = new PersonFavorite[personFavorite.length - 1];
				//sets a counter integer for the temp array
				int x = 0;
				//loops through and adds everything except the person to be removed to the temp array
				for(int i = 0; i < personFavorite.length; i++) {
					
					if(personFavorite[i] != personRemove[0]) {
						temp[x] = personFavorite[i];
						x++;
					}
				}
				//sets the current array to equal the temporary array
				personFavorite = temp;
				
				return personFavorite;
				
			}
			
			
			
			
			
			
			
			
			
			

}
