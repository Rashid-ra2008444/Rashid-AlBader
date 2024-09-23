import java.util.Scanner;

public class P11 {
    //Write a Java program that keeps accepting numbers from the user until a
    //negative value is entered. The program then calculates number of entered values,
    //their sum & average. Format your output to show the average to 2 decimal places.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = 0;
        double sum = 0;
        double counter = 0;
        while(x!= -1) {
            System.out.println("Enter positive values, or -1 to exit: ");
            x = scanner.nextInt();
            if(x != -1) {
                sum += x;
                counter++;
            }
        }
        scanner.close();
        System.out.printf("You entered %.0f numbers, sum is %.0f, average is %.2f\n", counter, sum, sum/counter);
    }
}
