import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void Counter(int x , int y) {

        while ( x<= y ) {
            System.out.println("The following number left to become 0 is "+ (y-x));
            System.out.println(x);
            x++;

        }
        System.out.println("Done");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide x");
        int x = scanner.nextInt();

        System.out.println("provide y");

        int y = scanner.nextInt();

        Counter(x, y);

    }
}