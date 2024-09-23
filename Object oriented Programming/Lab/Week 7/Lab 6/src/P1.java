import java.util.Scanner;

public class P1 {
	
	
	public static int search(int array[],int value) {
		for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
	}
	
	public static void replace(int array[],int searchValue,int replaceValue) {
		for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                array[i] = replaceValue;
            }
        }
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int reading[] = new int[5];
		for (int i = 0; i < reading.length; i++) {
			System.out.print("Enter element no.  "+ i + "--->");
            reading[i] = scanner.nextInt();
        }
		scanner.close();
		
		System.out.println("Before replacing");
		for (int i = 0; i < reading.length; i++) {
            System.out.print(reading[i] + " ");
        }
		System.out.println(" ");
		System.out.println("After replacing");
		replace(reading,2,9);
		for (int i = 0; i < reading.length; i++) {
            System.out.print(reading[i] + " ");
        }
    }
	
	
	
	
}
