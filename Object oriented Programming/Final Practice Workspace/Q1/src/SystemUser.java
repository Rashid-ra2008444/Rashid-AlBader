
public abstract class SystemUser {
	 String userName;
	 String password;
	
	public abstract String getUserID();
	
	
	// Q2 create the method boolean validate(String username_temp , String password_temp).
	// this method should return true if the attributes userName and password in the class SystemUser
	// are EXACTLY the same as the ones passed as arguments of the method (username_temp and password_temp).
	//otherwise, this method return false
	public boolean validate(String username_temp,String password_temp) {
		
		return username_temp.equals(getUserName()) && password_temp.equals(getPassword());
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
