package P2;

public class Car extends Vehicle {
	private int passengers;

	public Car() {
	}

	public Car(int wheels, int weight, int passengers) {
		super(wheels, weight);
		this.passengers = passengers;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Passengers : " + passengers;
	}
	
	@Override
	public String getAsCSV() {
		return super.getAsCSV() + "," + passengers;
	}
}
