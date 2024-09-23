package P3;

import java.util.Random;
import java.util.Scanner;

public class CircleArrayTester {
	
	
	public static double getAverageArea(Circle circles[]) {
		double sum = 0;
        for (int i = 0; i < circles.length; i++) {
            sum += circles[i].getArea();
        }
        return sum / circles.length;
	}
	

	
	
	
	//Add a static method called scaleUp(Circle circles[]) that enlarges each circle in the circles
	//array using a random number between 2 and 9 inclusive. 
	public static void scaleUp(Circle circles[]) {
				Random random = new Random();
				for (int i = 0; i < circles.length; i++) {
                    circles[i].enlarge(random.nextDouble(2,10));
                }
	}
	
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the size of the array:");
			int size = input.nextInt();
			Circle circles[] = new Circle[size];
			for (int i = 0; i < circles.length; i++) {
			System.out.println("Enter the radius");
			double radius = input.nextDouble();
			circles[i]=new Circle(radius);
			}
			System.out.println("Circles List:");
			//write code to print the radius, area and circumference
			//for all the circles, each on a line.
			for (int i = 0; i < circles.length; i++) {
                System.out.println(circles[i].getRadius());
            }
			System.out.println("Before ");
			System.out.println("Average area of circles: "+ getAverageArea(circles));
			System.out.println("After");
			scaleUp(circles);
			System.out.println("Average area of circles: "+ getAverageArea(circles));
			
			
			
			input.close();
		}
}
