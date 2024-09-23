package Ex2;

public class Invoice implements Payable{
	private String partNumber;
	private String partDescription;
	private double quantity;
	private double unitPrice;
	
	public Invoice(String partNumber, String partDescription, double quantity, double unitPrice) {
			super();
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
	}

	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return quantity * unitPrice;
	}

	@Override
	public String toString() {
		return "Invoice [partNumber=" + partNumber + ", partDescription=" + partDescription + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + "]";
	}
	
	

}
