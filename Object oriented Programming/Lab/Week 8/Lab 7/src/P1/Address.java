package P1;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;

	public Address(String street, String city, String state, String zip) {
		setStreet(street);
		setCity(city);
		setState(state);
		setZip(zip);
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getStreet() {
		return street;
	}

	public String getZip() {
		return zip;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return street + ", " + city + ", " + state + " " + zip;
	}

}
