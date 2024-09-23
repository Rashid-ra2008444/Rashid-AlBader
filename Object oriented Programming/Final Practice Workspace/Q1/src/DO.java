
public class DO {
	String name;
	String ID;
	TYPE userType;
	
	public DO(String name,String ID , TYPE userType) {
		setName(name);
		setID(ID);
		setUserType(userType);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public TYPE getUserType() {
		return userType;
	}

	public void setUserType(TYPE userType) {
		this.userType = userType;
	}
	
	
	
}
