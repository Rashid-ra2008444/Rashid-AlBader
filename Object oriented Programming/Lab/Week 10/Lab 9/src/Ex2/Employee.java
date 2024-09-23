package Ex2;

public class Employee implements Payable{
	private String firstName;
	private String lastName;
	private String qid;
	
	public Employee(String firstName, String lastName, String qid) {
			super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.qid = qid;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", qid=" + qid + "]";
	}
	
	

}
