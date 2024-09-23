

public class P3 {
	
	public static boolean isOdd(int i) {
		return (i%2) !=0;
	}
	
	public static boolean isPrime(int i) {
		for (int j=2; j <= Math.sqrt(i); j++) {
            if (i%j == 0) {
                return false;
            }
        }
        return true;
	}
	
	
	public static void main(String[] args) {
		int count = 0;
		for (int i=1; i <= 100; i++) {
			if (isPrime(i)) {
				System.out.println(i);
				count++;
            }	
		}
		System.out.println(count + " prime numbers from 0 to 1000");
    }
	

}
