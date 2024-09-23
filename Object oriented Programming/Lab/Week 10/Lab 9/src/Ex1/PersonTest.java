package Ex1;

import java.time.LocalDate;

public class PersonTest {
	public static void main(String[] args) {
	
		LocalDate date = LocalDate.of(2001, 1, 15);
		Person p1 = new Person("Mona", date, Gender.FEMALE);
		Person p2 = new Person("Ali", LocalDate.of(2002, 11, 20), Gender.MALE);
		if (p1.getBirthDate().isBefore(p2.getBirthDate())) {
			System.out.println("P1 is older than P2");
		}
		else {
			System.out.println("P2 is older than P1");
		}
	}

}
