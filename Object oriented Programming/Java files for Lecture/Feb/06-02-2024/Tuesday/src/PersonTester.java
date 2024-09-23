public class PersonTester {
    public static void main(String[] args) {

        Person person1 = new Person();
        Person person2 = new Person("Ahmed",21);

        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person2);
        person1.setAge(21);
        System.out.println(person2.sameAge(person1));


    }
}
