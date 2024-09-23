import java.math.*;
import java.util.Scanner;

public class P2 {

    public static int inputValidN() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive odd integer number : ");
        int n = scanner.nextInt();

        while(n <= 0 || n%2==0) {
            System.out.println("Invalid value");
            System.out.print("Enter a positive odd integer number : ");
            n = scanner.nextInt();
        }

        return n;
    }
    public static double f(int x, int n){

        double sum = x;

        int sign = -1;

        for(int i =3 ;i < n; i+=2) {
            sum+= sign*Math.pow(x,i)/ factorial(i);
            sign*=-1;
        }
        return sum;
    }
    public static double  factorial(int n) {
        double factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        int n = inputValidN();

        for ( int i = 0 ; i < 10 ; i++){
            double y = f(i,n);
            System.out.println("f("+i+") = "+y);
        }

    }
}
