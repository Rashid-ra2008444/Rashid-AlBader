import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int watt = scanner.nextInt();
        int brightness = switch (watt) {
            case 15 -> 125;
            case 25 -> 215;
            case 40 -> 500;
            case 60 -> 880;
            case 75 -> 1000;
            case 100 -> 1675;
            default -> -1;
        };

        if(brightness != -1){
            System.out.printf("%5d watts will generate %d brightness",watt,brightness);
        }
        else {
            System.out.println("Invalid input");
        }


    }

}
