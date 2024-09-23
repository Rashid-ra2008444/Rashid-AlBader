import java.util.Locale;
import java.util.Scanner;

public class W1 {

    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter x: ");

    double x = scanner.nextDouble();
    double y;

    if(x < 0) {
        y = 2*x-3;
        System.out.printf("y= %.3f\n", y);
    }
    else if(x == 0) {
        y = 10;
        System.out.printf("y= %.3f\n", y);
    }
    else {
        y = 3*Math.pow(x,2)+Math.PI;
        System.out.printf("y= %.3f\n", y);
    }

    }
}
