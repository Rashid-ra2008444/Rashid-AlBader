import java.util.Scanner;

public class W2 {

    public static void main(String[] args){
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        switch(option){
            case 1:
                System.out.println("You have Chosen 1 :D");
                break;
            case 2:
                System.out.println("You have Chosen 2 :D");
                break;
            case 3:
                System.out.println("You have Chosen 3 :D");
                break;
            case 4:
                System.out.println("You have Chosen 4 :D");
                break;
            default:
                System.out.println("Invalid Option :(");
                // So if you want to call the function after you choose invalid option then
                // implement it here, so you can choose another one
                break;
        }
    }



}
