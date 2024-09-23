import java.util.Scanner;

public class P1 {
    //Write a program that repeatedly receives the price and quantity of items until the user has no more items.
    //Each time it gets a valid price and a valid quantity of an item, it displays the price, the quantity, the amount before tax, the tax, the amount after tax.
    // When the user has no more items, the program displays the total before tax, the total tax, and the total after tax for all items.
    // The tax is a fixed percentage, 15%.
    // The program should validate user input of the price and quantity to be positive numbers
    // and insists that they should be by asking the user to reenter the value of any if invalid.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double price,totalTax, total, subtotal,tax = 0.15;
        int quantity = 0;
        String again = "y";
        double finalTotal =0,finalTotalTax =0,finalSubTotal = 0;
        do {
            System.out.print("Enter the price: ");
            price = input.nextDouble();
            while (price <= 0) {
                System.out.print("Enter the price: ");
                price = input.nextDouble();
            }
            System.out.print("Enter the quantity: ");
            quantity = input.nextInt();
            while (quantity <= 0) {
                System.out.print("Enter the quantity: ");
                quantity = input.nextInt();
            }
            total = price * quantity;
            totalTax = total * tax;
            subtotal = total + totalTax;
            System.out.printf("Price: %.2f, Quantity: %d, Total: %.2f, Tax: %.2f, Subtotal: %.2f\n",price,quantity,total,totalTax,subtotal);
            System.out.println("Do you have more items(y/n)?: ");
            finalTotal+=total;
            finalTotalTax+=totalTax;
            finalSubTotal+=subtotal;

            again = input.next();
        } while (!again.equals("n"));

        System.out.println("Total amount before tax: "+finalTotal);
        System.out.println("Total Tax: "+finalTotalTax);
        System.out.println("Total amount after tax: "+finalSubTotal);

        input.close();
    }
}
