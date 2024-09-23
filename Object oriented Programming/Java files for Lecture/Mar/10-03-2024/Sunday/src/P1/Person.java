package P1;

public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    public Person(){}

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return String.format("Name: %s, age: %d", name,age);
    }


}