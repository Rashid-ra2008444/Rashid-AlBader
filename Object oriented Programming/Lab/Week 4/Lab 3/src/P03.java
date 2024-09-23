import java.util.Scanner;

public class P03 {
    //**  Write a Java program and compute the sum of the digits of an integer. **\\
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int y;
        int x = scanner.nextInt();
        scanner.close();
        y = x;
        int sum =0;
        while(y!=0) {
            int digit = y % 10;
            sum+= digit;
            y /= 10;
        }
        System.out.println("sum = "+sum);
    }
}
