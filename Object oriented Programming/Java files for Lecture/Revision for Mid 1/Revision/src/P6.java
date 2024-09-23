import java.util.Scanner;

public class P6 {

    // write a code that separate 3 numbers for example 257 to [2,5,7]
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 3 digit number: ");
        int userInput =input.nextInt();
        int temp;
        int a = userInput % 10;
        temp = userInput /10;
        int b = temp % 10;
        int c = temp / 10;

        System.out.println("["+c + " " + b + " " + a+"]");
    }


}
