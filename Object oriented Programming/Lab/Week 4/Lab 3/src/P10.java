import java.util.Scanner;

public class P10 {
    // Write a Java program that takes two points from the user (x1, y1) & (x2, y2)
    //then calculates the distance between them, given this formula:
    //	𝑫𝒊𝒔𝒕𝒂𝒏𝒄𝒆 = √(𝒙𝟐 − 𝒙𝟏)𝟐 + (𝒚𝟐 − 𝒚𝟏)𝟐

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x1 : ");
        double x1 = scanner.nextDouble();
        System.out.println("Enter x2 : ");
        double x2 = scanner.nextDouble();
        System.out.println("Enter y1 : ");
        double y1 = scanner.nextDouble();
        System.out.println("Enter y2 : ");
        double y2 = scanner.nextDouble();
        scanner.close();


        double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));

        System.out.printf("Distance between(%.2f,%.2f) & (%.2f,%.2f) is %.2f",x1,x2,y1,y2,distance);
    }
}
