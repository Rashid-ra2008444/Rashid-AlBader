package P2;

import P1.Address;

public class Publisher {
	private int id;
	private String name;
	private String email;
	private Address address;

	public Publisher(int id, String name, String email) {
		setId(id);
		setName(name);
		setEmail(email);
	}
	
	
	public Publisher(int id, String name, String email,Address address) {
		this(id, name, email);
		setAddress(address);
	}
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Publisher ID: " + id + ", " + name + ", email=" + email+", Address=" + address.toString();
	}
}
