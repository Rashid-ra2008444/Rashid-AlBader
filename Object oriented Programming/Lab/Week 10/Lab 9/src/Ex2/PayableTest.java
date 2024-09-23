package Ex2;

import java.util.ArrayList;

public class PayableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create payable list
		ArrayList<Payable> payables = new ArrayList<Payable>();

		// populate list with objects that implement Payable
		payables.add(new Invoice("01234", "Textbook", 2, 375.00));
		payables.add(new Invoice("56789", "USB Disk", 3, 179.95));
		payables.add(new SalariedEmployee("Ahmed", "Ali", "111-11-1111", 15000.00));
		payables.add(new HourlyEmployee("Fatima", "Saleh", "222-22-2222", 160.75, 40));
		payables.add(new ComissionEmployee("Samir", "Sami", "333-33-3333", 100000, .06));
		System.out.println("Invoices and Employees processed polymorphically:\n");
		// generically process each element in array payableObjects
		for (Payable payable : payables) {
			// output currentPayable and its appropriate payment amount
			System.out.printf("ObjectType: %s - PaymentAmount = QR %.2f\n", payable.getClass().getSimpleName(),
					payable.getPaymentAmount());
			// If SalariedEmployee then increase the salary by 10%
			if (payable instanceof SalariedEmployee) {// downcast Payable reference to
														// BasePlusCommissionEmployee reference
				SalariedEmployee salariedEmployee = (SalariedEmployee) payable;
				double oldBaseSalary = salariedEmployee.getSalary();
				salariedEmployee.setSalary(oldBaseSalary * 1.1);
				System.out.printf("New salary with 10%% increase is: QR %,.2f\n", salariedEmployee.getSalary());
			}
		}

	}
}
