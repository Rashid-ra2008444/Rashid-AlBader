import java.util.ArrayList;
import java.util.Scanner;

public class OddEven {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);




        System.out.println("How many numbers you want to add to your arrayList? ");

        int x = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for ( int i = 0; i < x; i++ ) {
            System.out.println("Enter your "+ (i+1)+" number");
            int number = scanner.nextInt();

            list.add(number);
        }

        System.out.println("Your ArrayList: "+ list);
        int total = 0;
        for(int num : list) {
            total += num;
        }
        System.out.println("Total: "+ total);
    }

}
