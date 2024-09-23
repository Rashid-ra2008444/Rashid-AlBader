import java.util.Scanner;

public class Ex6 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
         System.out.print("Enter Math's mark: ");
         double math = scanner.nextDouble();
         System.out.print("Enter Computer's mark: ");
         double computer = scanner.nextDouble();
         System.out.print("Enter Music's mark: ");
         double music = scanner.nextDouble();

         double highest;
         double lowest;
         double sum = computer+ music + math;
         double avg = sum/3;

         if(math > computer && math > music){
             highest = math;
         }
         else if(computer > math && computer > music){
             highest = computer;
         }
         else {
             highest = music;
         }

         if(math < computer && math < music){
             lowest = math;
         }
         else if(computer < math && computer < music){
             lowest = computer;
         }
         else {
             lowest = music;
         }

         System.out.println("Highest mark is: " + highest);
         System.out.println("Lowest mark is: " + lowest);
         System.out.println("Total mark is: " + sum);
         System.out.println("Average mark is: " + avg);
    }
}
