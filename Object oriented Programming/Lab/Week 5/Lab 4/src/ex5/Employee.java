package ex5;

public class Employee {
	private String firstName;
	private String lastName;
	private double salary;
	
	
	
	public Employee(String firstName, String lastName, double salary) {
		
		setFirstName(firstName);
		setLastName(lastName);
		setSalary(salary);
		
	}
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	
	public double getYearlySalary() {
		return salary * 12;
	}
	public void setSalary(double salary) {
		if(salary < 0) {
			this.salary = 0.0;
		}
		else {
			this.salary = salary;
		}
	}
	
	public double getTax() {
		double tax;
		if(this.getSalary() < 10000) {
			tax = this.getSalary() * 0.1;
		}
		else {
			tax = this.getSalary() * 0.2;
		}
		return tax;
	}
	
	public double getNetSalary() {
		return this.getSalary() - this.getTax();
	}
	
	public void setBonus(double bonus) {
		this.setSalary(this.salary *bonus);
	}
	
	public double getYearlyTax() {
		double tax;
		if(this.getYearlySalary() < 100000) {
            tax = this.getSalary() * 0.1;
        }
		else {
			tax =this.getYearlySalary() * 0.2;
		}
		return tax;
	}
	
	public double getNetYearlySalary() {
		return this.getYearlySalary() - this.getYearlyTax();
	}
	
}
