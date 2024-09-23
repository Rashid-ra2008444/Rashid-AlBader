package ex6;

public class InvoiceTester {

	public static void main(String[] args) {

		Invoice invoice1 = new Invoice("Apple","fruit",3,5.95);
		Invoice invoice2 = new Invoice("Orange","fruit",2,3.99);
		
		System.out.println("The price in the first invoice is :"+invoice1.getInvoiceAmount());
		System.out.println("The price in the second invoice is :"+invoice2.getInvoiceAmount());
	}

}
