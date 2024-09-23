public class Person {
    private String name;
    private int age;
    public Person(){}

    public void setName(String name){
        // checking if the name is not empty or contains only spaces
        if(!name.isBlank()) {
            this.name = name;
        }
        else {
            System.out.println("Invalid name should not be empty");
        }
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Person(String name, int age){
        setName(name);
        setAge(age);
    }

    public boolean sameAge(Person other){
        //this method to check if this person has same age of other person
        return age == other.getAge();
    }

    public static boolean sameAge(Person person1 , Person person2) {
        return person1.age == person2.age;
    }
    @Override
    public String toString(){
        return String.format("Name: %s, Age: %d", name, age);
    }
}
