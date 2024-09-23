public class P01 {
    //** Write a Java program to print the sum of all numbers from 1 to 100.**\\
    public static void main(String[] args) {
        int sum=0;
        for (int i=1; i<=100; i++) {
            sum+=i;
        }
        System.out.println("Sum of 1 to 100 is: "+sum);
    }


}
