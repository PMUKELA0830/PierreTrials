package com.phoneUtilities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="streetNumber")
	private int streetNumber;
	@Column(name="streetName")
	private String streetName;
	@Column(name="streetType")
	private String streetType;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zipCode")
	private long zipCode;

	public Address() {

	}

	public Address(int streetNumber, 
				   String streetName, 
				   String streetType,
				   String city, 
				   String 
				   state, 
				   long zipCode) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.streetType = streetType;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public void setStreetAddr(String streetAddress) {
		String[] tempAddr = streetAddress.split(" ");
		String newStrName = "";

		this.streetNumber = Integer.parseInt(tempAddr[0]);
		for (int i = 0; i < tempAddr.length; i++) {
			newStrName += tempAddr[i];
			if (i != tempAddr.length - 2) {
				newStrName += " ";
			} else {
				newStrName += ",";
			}
		}
		this.streetName = newStrName;

	}

	public String getStreetAddr() {
		return streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String printAddress(int streetNumber, 
			   				   String streetName, 
			   				   String streetType, 
			   				   String city, 
			   				   String state, 
			   				   long zipCode) {
		
		String addressLayout = "";
		addressLayout = streetNumber + " " + streetName + " " + streetType 
		+ ", " + city + ", " + state + " " + zipCode;
		
		//System.out.println(streetNumber + " " + streetName + " " + streetType 
		//+ ", " + city + ", " + state + " " + zipCode;;
		return addressLayout;
	}

}
