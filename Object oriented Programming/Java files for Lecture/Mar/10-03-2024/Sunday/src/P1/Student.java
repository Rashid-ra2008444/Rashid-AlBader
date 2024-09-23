package P1;

public class Student extends Person{
    private double GPA;
    private String major;

    public Student(String name, int age,double GPA,String major){
        super(name,age);
        setMajor(major);
        setGPA(GPA);
    }

    public void setGPA(double GPA){
        this.GPA = GPA;
    }

    public void setMajor(String major){
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("%s, GPA: %.2f, Major: %s",super.toString(),GPA,major);
    }

    public void register(){
        System.out.println("Registered");
    }
}
