import java.util.Scanner;

public class P2 {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        // this code show do/while loop " I don't like it"
        int sum = 0;
        int n;
        do {
            n = scanner.nextInt();
            sum+=n;
        }while(n > 0);
        System.out.println(sum);
    }
}
