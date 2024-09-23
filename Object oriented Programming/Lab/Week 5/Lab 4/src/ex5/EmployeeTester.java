package ex5;

public class EmployeeTester {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Ahmed","Ali",3500);
		Employee emp2 = new Employee("Mohammed","Abdulla",5000);

		System.out.printf("Employee 1 : %s %s; Yearly Salary: %.2f\n",emp1.getFirstName(),emp1.getLastName(),emp1.getYearlySalary());
		System.out.printf("Employee 2 : %s %s; Yearly Salary: %.2f\n",emp2.getFirstName(),emp2.getLastName(),emp2.getYearlySalary());
		System.out.println("Increasing employee salary by 10%");
		
		System.out.printf("Employee 1 : %s %s; Yearly Salary: %.2f\n",emp1.getFirstName(),emp1.getLastName(),(emp1.getYearlySalary()*0.10)+emp1.getYearlySalary());
		System.out.printf("Employee 2 : %s %s; Yearly Salary: %.2f\n",emp2.getFirstName(),emp2.getLastName(),(emp2.getYearlySalary()*0.10)+emp2.getYearlySalary());
		
		
	}

}
