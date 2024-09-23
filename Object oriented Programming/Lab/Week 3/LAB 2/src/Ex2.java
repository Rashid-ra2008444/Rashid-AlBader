import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mark;

        System.out.println("Enter mark (an integer): ");
        mark = scanner.nextInt();

        double value = (double) mark/20;

        switch((int) value){
            case 5 , 4 :
                System.out.println("Excellent");
                break;
            case 3:
                System.out.println("Very good");
                break;
            case 2:
                System.out.println("Good");
            default:
                System.out.println("Fail");
        }
        scanner.close();
    }

}
