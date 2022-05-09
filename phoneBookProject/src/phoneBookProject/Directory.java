package phoneBookProject;

import java.util.Scanner;

public class Directory {
	
	Person[] person = new Person[0];
	
	public void addPerson(Person newPerson) {
		
		Person[] temp = new Person[person.length + 1];
		
		for (int i = 0; i < person.length; i++) {
			temp[i] = person[i];
			
		}
		
		temp[temp.length - 1] = newPerson;
		
		person = temp;
	}
	
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
	
	public Person sortingContactsAlph() {
		Person[] sortContactList = getDirectory();
		Person tempContact = sortContactList[0];
		for (int i = 0; i < sortContactList.length; i++) {
			for (int j = i+1; j < sortContactList.length; j++) {
				if(sortContactList[i].getFirstName().compareTo(sortContactList[j].getFirstName())> 0) {
				tempContact = sortContactList[i];
				sortContactList[i] = sortContactList[j];
				sortContactList[j] = tempContact;
				
				//sortContactList = tempContact;
				
				}
				tempContact = sortContactList[i];
			}
		}
		return tempContact;
	}
	
	
	
	
	//Search methods
	//Search by firstname
	
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
		int counter = 0;
		for (int i = 0; i < person.length; i++) {
			if(person[i].getAddress().getCity().equalsIgnoreCase(cityOrStateKeyword) 
			|| person[i].getAddress().getState().equalsIgnoreCase(cityOrStateKeyword)) {
			counter++;
			}
			
		}
		//New array to hold contacts found in the directory
		Person[] tempArray3 = new Person[counter];
		
		//Populate the results
		int tempCounter1 = 0;
		
		for (int i = 0; i < person.length; i++) {
			
			if (person[i].getAddress().getCity().equalsIgnoreCase(cityOrStateKeyword) 
				|| person[i].getAddress().getState().equalsIgnoreCase(cityOrStateKeyword)) {
			tempArray3[tempCounter1] = person[i];
			tempCounter1++;
				}	
		}
		return tempArray3;
	}
	
	//Creating a new contact and adding it to the contact list of the phone book.
	
	public Person createContact() {
		
		System.out.println("Please enter new contact's information to be separated by commas");
		System.out.println("Information Format: Name, Street Address, City (no periods, i.e. St Louis not St. Louis)"
		 + "State, ZipCode, Phone Number ");
		
		Scanner scan2 = new Scanner(System.in);
		String info = scan2.nextLine();
		 // separating the info into array of strings
		String[] tempInfo = info.split(", ");

		 // set variables for each index
		 String name = tempInfo[0];
		 String street = tempInfo[1];
		 String city = tempInfo[2];
		 String state = tempInfo[3];
		 Long ZipCode = Long.parseLong(tempInfo[4]);
		 String phoneNumber = tempInfo[5];

		 //split the name
		 String[] tempName = name.split(" ");

		 // First name is always first
		 String firstName = tempName[0];
		 String lastName = tempName[tempName.length - 1];
		
		String middleName = "";
		
		for (int i = 1; i < tempName.length - 1; i++) {
			middleName += tempName[i];
			if (i != tempName.length - 2) {
				middleName += " ";
			}
			
		}
		// Split street name
		String[] tempAddress = street.split(" ");
		String streetName = "";
		int streetNumber = Integer.parseInt(tempAddress[0]);
		for (int i = 1; i < tempAddress.length; i++) {
			streetName += tempAddress[i];
			if (i != tempAddress.length -1) {
				streetName += " ";
			}
		}
		
		Person person1 = new Person("Pierre", "Hutu", "Mukela", 
				"6564124879");
		
		//Directory contactList = new Directory();
		
		person1.addAddress(4576, "Shear Ave", "City", "FL", 75441);
		
		Person person2 = new Person("John", "E", "Doe", "8475390126");
		person2.addAddress(324, "Main St", "St Charles", "MO", 63303);
		
		Person person3 = new Person(firstName, middleName, lastName, phoneNumber);
		person3.addAddress(streetNumber, streetName, city, state, ZipCode);
	
	
	// This is to add or save the contact in the Contact list
	this.addPerson(person1);
	this.addPerson(person2);
	this.addPerson(person3);
	
	//Display all contacts
	this.printDirectory();
	
	return person3;
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
	

