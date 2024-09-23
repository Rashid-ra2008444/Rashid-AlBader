package ex6;

public class Invoice {
	private String id;
	private String description;
	private int quantity;
	private double pricePerItem;
	
	
	public Invoice(String id, String description, int quantity, double pricePerItem) {
		setId(id);
		setDescription(description);
		setQuantity(quantity);
		setPricePerItem(pricePerItem);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		if(quantity < 0) {
			this.quantity = 0;
		}
		else {
		this.quantity = quantity;
		}
	}
	
	public double getPricePerItem() {
		return pricePerItem;
	}
	
	public void setPricePerItem(double pricePerItem) {
		if(pricePerItem < 0) {
			this.pricePerItem = 0.0;
		}
		else {
		this.pricePerItem = pricePerItem;
		}
	}
	
	
	public double getInvoiceAmount() {
		return (double)quantity * pricePerItem;
	}
	
}
