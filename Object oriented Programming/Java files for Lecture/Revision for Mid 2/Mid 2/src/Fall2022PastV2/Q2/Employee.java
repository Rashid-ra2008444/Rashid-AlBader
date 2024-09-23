package Fall2022PastV2.Q2;

import java.util.ArrayList;

//Q.2 Consider the class Employee below to add the needed code for the below tasks.
// Notice that the employees list is static and its purpose is to save the references to Employee created objects.

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

    //(a) Code the body of the first constructor such that it insures every created Employee object is added to
    // the employees static list and is assigned a proper employment ID, employeeId, taking advantage of the serialNo static class variable.
    public Employee() {
        this.employeeId = serialNo++;
        employees.add(this);
    }

    //(b) Code the body of the second constructor receiving the name and salary of an employee.
    // This constructor should take advantage of the first constructor and also should set the name and salary
    public Employee(String name, double salary){
        this();
        setName(name);
        setSalary(salary);
    }

    //(c) Code the body of the method increase. This method increases, by a specified percentage increment,
    // the salary of employees whose salary is below a specified value, salary.
    // This method should return the total number of benefited employees from this increase.
    public  int increase(int increment,double salary) {
        int count =0;
        for(Employee e: employees){
            if(e.getSalary()<salary){
                e.setSalary(e.getSalary()+(e.getSalary()*increment));
                count++;
            }
        }
        return count;
    }
}
