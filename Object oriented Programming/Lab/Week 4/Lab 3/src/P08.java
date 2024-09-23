import java.util.Scanner;

public class P08 {
    // Write a program to evenly divide pizzas. Prompt for the number of people, the
    //number of pizzas, and the number of slices per pizza. Ensure that the number of
    //pieces comes out even. Display the number of pieces of pizza each person should
    //get. If there are leftovers, show the number of leftover pieces.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many people? ");
        int people = scanner.nextInt();
        System.out.println("How many pizzas do you have? ");
        int pizzas = scanner.nextInt();
        scanner.close();
        //didn't solve it yet
        System.out.printf("%d people with %d pizzas", people, pizzas);

    }

}
