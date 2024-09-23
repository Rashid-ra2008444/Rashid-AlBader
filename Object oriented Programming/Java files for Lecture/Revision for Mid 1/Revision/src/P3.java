import java.util.Scanner;

public class P3 {
    // Write java code that make the user enter a number and if the user entered an odd number make a counter that count how many times the user entered,
    //also for the even number.
    // let the user enter -1 if he wants to stop writing and print how many times the user entered odd and even numbers

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int isOdd = 0 ;
        int isEven = 0;
        System.out.print("Enter a number(-1 to exit): ");
        int userInput =input.nextInt();

        while(userInput!=-1) {


            if(userInput % 2 == 0) {
                isEven++;
            } else {
                isOdd++;
            }
            System.out.print("Enter a number(-1 to exit): ");
            userInput = input.nextInt();
        }
          System.out.println("Odd number entered: "+isOdd);
        System.out.println("Even number entered: "+isEven);
    }
}
