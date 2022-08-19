package com.phoneUtilities.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import com.phoneUtilities.service.AddressService;
//import com.phoneUtilities.service.PersonService;

@Entity
@Table(name="person")
public class Person {
	
	
	@Column(name="firstName")
	private String firstName;
	@Column(name="middleName")
	private String middleName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	
	
	@Id
	@Column(name="phoneNumber")
	private String phoneNumber;
	@Column(name="address")
	private String address;
	
	public String addAddress(int streetNumber, 
			   String streetName, 
			   String streetType, 
			   String city, 
			   String state, 
			   long zipCode) {
//		Address tempAddress = new Address(streetNumber, 
//							  streetName, 
//							  city, 
//							  state, 
//							  zipCode);
		Address address = new Address();
		
		// Construct address using the following constructor
		String addressComplete = address.printAddress(streetNumber, 
													  streetName, 
													  streetType, 
													  city, 
													  state, 
													  zipCode);
		this.address = addressComplete;
		this.city = city;
		this.state = state;
		return addressComplete;
}

//	public void setAddress(String addressComplete) {
//		AddressService addressService = new AddressService();
//		addressComplete = addressService.printAddress(streetNumber, streetName, streetType, city, state, zipCode);
//		this.address = addressComplete;
//	}
	
	public String getAddress() {
		return this.address;
	}

	public Person() {
		
		
	}
	
	public Person(String firstName,  
			  	  String lastName, 
			  	  String phoneNumber) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Person(String firstName, 
				  String middleName, 
				  String lastName, 
				  String phoneNumber) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

//	public void getPerson() {
//		if (middleName.length() != 0) {
//			System.out.println("\n" + firstName + " " + middleName + " " + lastName);
//		} else {
//			System.out.println(firstName + " " + lastName);
//		}
//		address.printAddress();
//		System.out.println("Phone Number: " + formatPhone(phoneNumber));
//		System.out.println("-----------------------------------------");
//	}

	// Format phone number
//	public String formatPhone(String phoneNumber) {
//		String formattedPhone = "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-"
//				+ phoneNumber.substring(6, 10);
//		return formattedPhone;
//	}
	
	
	// Format phone number
	public String formatPhone(String phoneNumber) {
		String formattedPhone = "(" + phoneNumber.substring(0, 3) + ")" 
									+ phoneNumber.substring(3, 6) + "-"
									+ phoneNumber.substring(6, 10);
		return formattedPhone;
	}
	
	// Customized getter for person
	public String getPerson() {
		
		String contact ="";
		String personContact = "";
		if (getMiddleName().length() != 0) {
			contact = "\n" + getFirstName() + " " + getMiddleName() 
					  + " " + getLastName() + "\n";
			//System.out.println("\n" + person.getFirstName() + " " 
			//+ person.getMiddleName() + " " + person.getLastName());
		} else {
			contact = "\n" + getFirstName() + " " + getLastName() + "\n";
			//System.out.println(person.getFirstName() + " " + person.getLastName());
		}
		
		personContact = contact + getAddress() + "\n" 
				+ "Phone Number: " + formatPhone(getPhoneNumber()) + "\n"
				+ "-----------------------------------------";
		
		return personContact;
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
