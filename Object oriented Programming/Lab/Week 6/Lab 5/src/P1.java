import javax.swing.JOptionPane;


public class P1 {

	public static void main(String[] args) {
		double n1, n2, sum, response;
		String firstNumber, secondNumber , product;
		do {
		// obtain user input (as String) from JOptionPane input dialogs
		firstNumber = JOptionPane.showInputDialog("Enter first integer");
		secondNumber = JOptionPane.showInputDialog("Enter second integer");
		product = JOptionPane.showInputDialog("Enter product");
		// convert String inputs to double values for use in a calculation
		n1 = Double.parseDouble(firstNumber);
		n2 = Double.parseDouble(secondNumber);
		
		sum = n1 + n2;
		JOptionPane.showMessageDialog(null, "Sum=" + sum + " Product: " + product);
		response = JOptionPane.showConfirmDialog(null,
		"Do you want to continue?",null,JOptionPane.YES_NO_OPTION);
		} while (response == JOptionPane.YES_OPTION);

		
		
    }
}
