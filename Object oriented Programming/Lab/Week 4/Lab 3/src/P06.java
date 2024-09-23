import java.util.Scanner;

public class P06 {
    //**  Write a Java program to request the user to type the time in seconds and display it in the standard format of hours:minutes:seconds. **\\
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time in seconds: ");
        int sec = scanner.nextInt();
        int hr = sec / 3600;
        int min = (sec - hr * 3600) / 60;
        int sec1 = sec - hr * 3600 - min * 60;
        System.out.println(hr + ":" + min + ":" + sec1);
        scanner.close();;
    }
}
