package P7;

public class Tester {
    //Write the missing code of the needed classes to enable this code to run and does what it is supposed to do without errors.
    // The missing code are Vehicle and Owner classes
    public Tester() {
        Vehicle v1 = new Vehicle(1621732); //plateNo
        v1.setOwner(new Owner("Huda Abdullah"));
        v1.getOwner().setId("12400007355");
        Vehicle v2 = new Vehicle();
        //deep copy of v1 saved in v2
        v1.copy(v2);
    }
    public static void main(String[] args) {
        new Tester();
    }
}
