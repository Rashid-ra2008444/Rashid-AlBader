package P2;

public class Student {
    private String id;
    private int year;
    private Dept dept;
    private String name;

    //Code the method genId that generates and returns a string value for the attribute id.
    // This value is a formatted string having the value of the attribute year followed by
    // the name of the attribute dept followed by a three-digit integer representing the
    // value of the attribute count of the dept object.
    // The method return null for a null Dept object.
    private String genId(){
        if(dept == null) {
            return null;
        }
        return String.format("%04d%s%03d",year,dept,dept.getCount());
    }

    //Code the method setId that receives a Dept object that is used to set the value of the attribute
    // dept then increments the value of the attribute count of the dept only if the count of the dept
    // is less than the capacity of it. Otherwise, the method does nothing except displaying the message
    // “Error: capacity is reached”.
    public void setDept(Dept dept){
        if(dept.getCount() < dept.getCapacity()) {
            this.dept = dept;
            dept.incCount();
        }
        else {
            System.out.println("Error: capacity is reached");
        }
    }

    //Code a constructor that receives a Dept object and use it to set the value of the attribute deptId
    // by calling setDept method then it sets the attribute deptId to the value
    // returned from calling the function genId.
    public Student(Dept dept){
            setDept(dept);
            id = genId();
    }

    //Override the method toString to return a formatted string having the values of all attributes.
    @Override
    public String toString(){
        return String.format("ID: %s, Year: %d, Dept: %s, Name: %s",id,year,dept,name);
    }

    //Code the class method equals that takes two Student objects and returns true
    // if all of their corresponding attributes are equal otherwise, it returns false.
    public static boolean equals(Student s1, Student s2){

        return s1.dept.equals(s2.dept) && s1.id.equals(s2.id) && s1.name.equals(s2.name) && s1.year==s2.year;
    }
}
