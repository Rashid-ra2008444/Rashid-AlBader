
public class Patient extends SystemUser{
	private String patientID;
	private String patientName;
	private String address;
	private int age;
	private boolean highPriority;
	
	public Patient() {}

	public Patient(String patientName,String address,int age){
		setPatientName(patientName);
		setAddress(address);
		setAge(age);
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHighPriority() {
		return highPriority;
	}

	public void setHighPriority(boolean highPriority) {
		this.highPriority = highPriority;
	}

	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
