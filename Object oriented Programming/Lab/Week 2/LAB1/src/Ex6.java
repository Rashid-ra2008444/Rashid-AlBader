import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Your Math Grade: ");
        double mathGrade = scanner.nextDouble();
        System.out.println("Enter Your English Grade: ");
        double englishGrade = scanner.nextDouble();
        System.out.println("Enter Your Computer Grade: ");
        double computerGrade = scanner.nextDouble();

        double average = (mathGrade + englishGrade + computerGrade) /3;

        if(average >= 60) {
            System.out.printf("Your average is %.2f and this is good thing",average);
        }
        else {
            System.out.printf("Your average is %.2f and this is not good thing",average);
        }
    }
}
