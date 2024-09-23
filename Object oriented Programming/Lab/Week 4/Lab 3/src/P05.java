import java.util.Scanner;

public class P05 {
    //** Write a Java program that accepts four integer from the user and prints equal if all four are equal, and not equal otherwise **\\
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first numbers");
        int first = scanner.nextInt();

        System.out.println("Enter the second numbers");
        int second = scanner.nextInt();

        System.out.println("Enter the third numbers");
        int third = scanner.nextInt();

        System.out.println("Enter the fourth numbers");
        int fourth = scanner.nextInt();

        if (first == second && second == third && third == fourth) {
            System.out.println("Numbers are Equal");
        }
        else {
            System.out.println("Numbers are not Equal");
        }
        scanner.close();
    }
}
