
public class Doctor extends SystemUser{
	private String name;
	private String doctorID;
	private double salary;
	
	public Doctor(String name, String doctorID, double salary) {
		setName(name);
		setDoctorID(doctorID);
		setSalary(salary);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
