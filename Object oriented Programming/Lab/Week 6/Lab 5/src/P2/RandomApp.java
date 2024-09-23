package P2;

import java.security.SecureRandom;

public class RandomApp {
	int a,b;
	public String generateQuestion() {
	SecureRandom sr = new SecureRandom();
	
	a = sr.nextInt(2,10);
	b = sr.nextInt(2,10);
	String q = String.format("What is the product of %d and %d", a,b);
	
	return q;
	}
	
	public boolean checkAnswer(int answer) {
		return (a*b) == answer;
	}
}
