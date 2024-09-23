package P9;

public class Employee {
    private String name;
    private int employeeId ;

    private static int employeeIdCounter = 100;

    private double salary;

    // write a constructor for the employee that whenever the employee is created make sure that it has unique id
    public Employee() {
        employeeId = employeeIdCounter++;
    }
    // write a constructor that initializes the employee name and salary including the employeeId
    public Employee(String name, double salary) {
        this();
        setName(name) ;
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +" "+employeeId +
                '}';
    }
}
