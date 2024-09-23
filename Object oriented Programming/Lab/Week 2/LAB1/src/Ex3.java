import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter your second number: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter your third number: ");
        int thirdNumber = scanner.nextInt();

        int sum = firstNumber + secondNumber + thirdNumber;
        double average = (double) sum / 3;

        System.out.println("The sum is " + sum);
        System.out.println("The average is " + average);


    }
}
