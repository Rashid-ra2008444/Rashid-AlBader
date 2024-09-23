import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double y = 0;

        System.out.println("Enter n(odd number): ");
        int n = scanner.nextInt();
        while(n % 2 != 1) {
            System.out.println("Enter n(odd number): ");
            n = scanner.nextInt();
        }
        scanner.close();

        for(int i =1 ; i<=n ; i++) {
            // this for nested loop for the factorial
            long f =1;
            int c = i+1;
            for(int j = 1 ; j<=c ; j++) {
                f = f*j;
            }
            System.out.printf("%d != %d\n",c,f);
            y+=(double)i/(i+1);
        }
        System.out.printf("y = %.2f\n", y);
    }
}
