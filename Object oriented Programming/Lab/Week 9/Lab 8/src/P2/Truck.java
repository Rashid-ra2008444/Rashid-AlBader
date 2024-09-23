package P2;

public class Truck extends Vehicle {
	private double load;
	
	public Truck() {}
	
	public Truck(int wheels, int weight, double load) {
        super(wheels, weight);
        setLoad(load);
    }

	public double getLoad() {
		return load;
	}

	public void setLoad(double load) {
		this.load = load;
	}
	
	public double getWheelLoad() {
		return (double)(load+super.getWeight())/super.getWheels();
	}
	
	@Override
	public String toString() {
		return String.format("%s\n Load Capacity: %.0f\n Wheel Load: %.2f",super.toString(), load,getWheelLoad());
				
	}
	
	@Override
	public String getAsCSV() {
        return super.getAsCSV() + "," + load;
    }
	
}
