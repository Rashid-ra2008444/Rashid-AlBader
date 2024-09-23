import java.util.Scanner;

public class P07 {
    //** Write a program that prompts for two numbers. Print the sum, difference, product, and quotient of those numbers as shown in the example output: **\\

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first numbers: ");
        String a = scanner.nextLine();
        System.out.println("Enter second numbers: ");
        String b = scanner.nextLine();

        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        System.out.printf("%d + %d = %d\n", x, y, x + y);
        System.out.printf("%d – %d = %d\n", x, y, x - y);
        System.out.printf("%d * %d = %d\n", x, y, x * y);
        System.out.printf("%d / %d = %d\n", x, y, x / y);

        scanner.close();
    }
}
