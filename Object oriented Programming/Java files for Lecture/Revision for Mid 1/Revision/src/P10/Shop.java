package P10;

public class Shop {
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Person person1 = new Person("Ahmed","101","12-01-2000",Genders.Male);
            Person person2 = new Person("Fatma","202","06-04-2003",Genders.Female);

            System.out.println("Ahmed salary before is " + 3000 + "after tax "+ (3000-(3000* person1.getGender().getTax())) );
        }
}
