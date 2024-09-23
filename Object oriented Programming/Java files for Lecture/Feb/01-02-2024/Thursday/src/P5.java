import java.util.Scanner;

public class P5 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers you want to sum");
        int x = scanner.nextInt();
        int sum = 0;

        for(int i = 1; i <=x ; i++){
            System.out.print("Num "+i+": ");
            int y = scanner.nextInt();
            sum+=y;
        }
        System.out.println("Sum = "+sum);
    }
}
