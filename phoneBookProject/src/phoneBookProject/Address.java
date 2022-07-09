package phoneBookProject;

public class Address {
	
	private int streetNumber;
	private String streetName;
	private String streetType;
	private String city;
	private String state;
	private long zipCode;
	
	public Address(){

	}
	public Address(int streetNumber, String streetName,
			String city, String state, long zipCode) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
//		this.streetType = streetType;
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
				newStrName += newStrName + " ";
			}
		} this.streetName = newStrName;
		
	}

	public String getStreetAddr(){
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
	
	public void printAddress() {
		System.out.println(streetNumber + " " + streetName + " " + 
				", " + city + ", " + state + " " + zipCode);
	}
	
	
}
