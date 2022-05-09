package phoneBookProject;

public class Person {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private Address address;
	
	public void addAddress(int streetNumber, String streetName, String city,
			String state, long zipCode) {
		Address tempAddress = new Address(streetNumber, streetName, 
				city, state, zipCode); 
			address = tempAddress;
			
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public Person() {
		
	}
	
	public Person(String firstName, String middleName, String lastName, 
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public void getPerson() {
		if(middleName.length() != 0) {
			System.out.println("\n" + firstName + " " + middleName + " " + lastName);
		} else {
			System.out.println(firstName + " " + lastName);
		}
		address.printAddress();
		System.out.println("Phone Number: " + formatPhone(phoneNumber));
		System.out.println("-----------------------------------------");
	}
	
	//Format phone number
	public String formatPhone(String phoneNumber) {
		String formattedPhone = "(" + phoneNumber.substring(0,3) + ")"
				+ phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,10);
		return formattedPhone;
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
