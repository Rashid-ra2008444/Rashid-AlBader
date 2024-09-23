package Ex2;

public class HourlyEmployee extends Employee{
	private double wage;
	private double hours;
	
	public HourlyEmployee(String firstName, String lastName, String qid, double wage, double hours) {
			super(firstName, lastName, qid);
        this.wage = wage;
        this.hours = hours;
	}
	
	@Override
	public double getPaymentAmount() {
        return wage *hours;
	}
	
    @Override
    public String toString() {
        return super.toString() + " " + wage + " " + hours;
    }
        
	

}
