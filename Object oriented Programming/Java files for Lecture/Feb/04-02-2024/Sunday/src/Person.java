public class Person {
    // identify person name and age as private so it cant be modified by other classes
    private String name;
    private int age;
    // this is defult constructior
    public Person() {
    }
    // this code only to get the name
    public String getName() {
        return name;
    }
    // this code only to set name
    public void setName(String name) {
        this.name = name;
    }
    // similar to get name this to get the age
    public int getAge() {
        return age;
    }
    // similar to set name this to set the age
    public void setAge(int age) {
        this.age = age;
    }
    // this constructor has attributes that the user can identify themselves directly from the constructor
    public Person(String name , int age ){
         setName(name);
         setAge(age);
    }
    // this code will print the name and age so when you print it dont show you the location of the person object you created
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
