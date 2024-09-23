package Ex2;

public class ComissionEmployee extends Employee {
	private double grossSales;
	private double commisionRate;
	
	public ComissionEmployee(String firstName, String lastName, String qid, double grossSales, double commisionRate) {
			super(firstName, lastName, qid);
        this.grossSales = grossSales;
        this.commisionRate = commisionRate;
	}
	
	@Override
    public double getPaymentAmount() {
        return grossSales+(commisionRate*grossSales);
    }
	

    @Override
    public String toString() {
    	return super.toString()+"\nGross Sales: "+grossSales+"\nCommission Rate: "+commisionRate;
    }
}
