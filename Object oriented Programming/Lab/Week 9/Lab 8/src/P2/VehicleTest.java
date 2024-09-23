package P2;

public class VehicleTest {
	public static void main(String args[]) {
		Vehicle bicycle = new Vehicle(2, 20);
		Car sedan = new Car();
		Car toyota = new Car(4, 2000, 5);
		Truck volvo = new Truck(12,4000,12000);
		sedan.setWheels(4);
		sedan.setPassengers(4);
		sedan.setWeight(1500);
		System.out.println(bicycle);
		System.out.println(sedan);
		System.out.println(toyota);
		System.out.println(volvo);
		System.out.println(volvo.getAsCSV());
	}

}
