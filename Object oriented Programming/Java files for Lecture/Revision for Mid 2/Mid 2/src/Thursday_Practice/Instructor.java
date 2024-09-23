package Thursday_Practice;

public class Instructor extends User{
   private double salary;

   public Instructor(String name, String username,double salary){
       super(name,username);
       setSalary(salary);
   }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return String.format("%sSalary: %.2f\n",super.toString(),salary);
    }
}
