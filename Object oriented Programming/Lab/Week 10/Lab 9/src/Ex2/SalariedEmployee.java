package Ex2;

public class SalariedEmployee extends Employee{
	

	private double salary;
	
	
	public SalariedEmployee(String firstName, String lastName, String qid , double salary) {
		super(firstName, lastName, qid);
		// TODO Auto-generated constructor stub
		setSalary(salary);
	}
	
	public double getPaymentAmount() {
        return this.getSalary();
    }

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
        return super.toString() + " Salary: " + this.getSalary();
    }
}
