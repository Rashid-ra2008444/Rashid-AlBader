package P5;

public class EmployeeTester {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", 123456789, 100000);
        Employee emp2 = new Employee("John", 123456789,500000);

        System.out.println(emp1.compareByName(emp2));
        System.out.println(emp2.compareByName(emp1));

        System.out.println(emp1.compareBySalary(emp2));
        System.out.println(emp2.compareBySalary(emp1));

        System.out.println(emp1.sameID(emp2));
        System.out.println(emp2.sameID(emp1));
    }
}
