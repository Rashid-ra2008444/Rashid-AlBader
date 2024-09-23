package P1;

public class Customer {
		private String name;
		private String phone;
		private int id;
		private Address address;
		
		public Customer(String name, String phone, int id) {
			setName(name);
			setPhone(phone);
			setId(id);
	 }
		
		public Customer(String name, String phone,int id, Address address) {
			this(name,phone,id);
			setAddress(address);
		}
		
		public Address getAddress() {
            return address;
        }
		public void setAddress(Address address) {
            this.address = address;
        }
	 public String getName() {
		 return name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public String getPhone() {
		 return phone;
	 }
	 
	 public void setPhone(String phone) {
		 this.phone = phone;
	 }
	 
	 public int getId() {
		 return id;
	 }
	 
	 public void setId(int id) {
		 this.id = id;
	 }
	 
	 public String toString() {
		 return "Name=" + name + ", phone=" + phone + ", id=" + id +", Address="+address.toString();
	 }

}
