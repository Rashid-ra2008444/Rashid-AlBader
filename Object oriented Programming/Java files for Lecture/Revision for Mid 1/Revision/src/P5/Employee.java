package P5;

public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        setName(name);
        setId(id);
        setSalary(salary);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

// write a method that returns true if the employee has same name in static way
    public static Boolean compareByName(Employee emp1 ,Employee emp2) {
        return emp1.getName().equals(emp2.getName());
    }
    // write a method that return true if the employees has same name in non-static way
    public Boolean compareByName(Employee emp){
        return this.getName().equals(emp.getName());
    }
    //write a static method that return true if employee 1 has higher salary than employee 2
    public static String compareBySalary(Employee emp1 , Employee emp2) {
        return emp1.getSalary() > emp2.getSalary() ? "First Employee is higher" : "Second Employee is higher";
    }
    // write a method that return true if employee 1 has higher salary than employee 2
    public String compareBySalary(Employee emp){
        return this.getSalary() > emp.getSalary()? "First Employee is higher" : "Second Employee is higher";
    }
    // write a static method that returns true if employee 1 has same id as employee 2
    public static boolean sameID(Employee emp1 , Employee emp2){
        return emp1.getId() == emp2.getId();
    }
    // write a method that returns true if employee 1 has same id as employee 2
    public boolean sameID(Employee emp){
        return this.getId() == emp.getId();
    }
}
