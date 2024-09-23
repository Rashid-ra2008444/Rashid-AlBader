import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        System.out.println("Welcome to Cylinder Calculator");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US) ;
            System.out.println("Enter the radius: ");
            double radius = scanner.nextDouble();

            while (radius <= 0.0) {
                System.out.println("Invalid value");
                System.out.println("Please enter a valid value: ");
                radius = scanner.nextDouble();
            }

            System.out.println("Enter Height: ");
            double height = scanner.nextDouble();

            while (height <= 0) {
                System.out.println("Invalid height");
                System.out.println("Please enter a valid height: ");
                height = scanner.nextDouble();
            }

            System.out.println("(1) Calculate and display the volume \n(2) Calculate and display the area\n(3) Exit");

            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Volume = " + (3.14 * (radius * radius) * height));
                    break;
                case 2:
                    System.out.println("Surface Area = " + (2 * 3.14 * (radius * radius) + 2 * 3.14 * radius * height));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
