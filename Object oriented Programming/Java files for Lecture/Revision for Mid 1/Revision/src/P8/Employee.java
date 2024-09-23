package P8;

import java.util.ArrayList;
public class Employee {
    private String name;
    private double salary;
    private int employeeId;
    private static int serialNo = 100;
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

//(a) Code the body of the first constructor such that it insures every created Employee
// object is added to the employees static list and is assigned a proper employment ID, employeeId,
// taking advantage of the serialNo static class variable.
    public Employee(){
        /* (a) */
        this.employeeId = serialNo++;
         employees.add(this);
    }

//(b) Code the body of the second constructor receiving the name and salary of an employee.
// This constructor should take advantage of the first constructor and also should set the name and salary.
    public Employee(String name , double salary){
        /* (b) */
    this();
    setName(name);
    setSalary(salary);
    }

//(c) Code the body of the method increase.
// This method increases, by a specified percentage increment,
// the salary of employees whose salary is below a specified value, salary.
// This method should return the total number of benefited employees from this increase.
    public int increment(int increment, double salary) {
        /* (c) */
        int count = 0;
        for (Employee emp : employees) {
            if (emp.getSalary() < salary) {
                double increasedSalary = emp.getSalary() * (1 + (double) increment / 100);
                emp.setSalary(increasedSalary);
                count++;
            }
        }
        return count;

    }


}