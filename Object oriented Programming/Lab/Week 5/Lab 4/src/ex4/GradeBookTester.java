package ex4;

public class GradeBookTester {

	public static void main(String[] args) {
		

		GradeBook gradeBook = new GradeBook("CMPS 251 Programming Lab","Rashid Al-Bader");
		
		gradeBook.displayMessage();
		System.out.println("Changing course instructor");
		
		gradeBook.setInstructor("Ahmed Ali");
		
		
		GradeBook gradeBook2 = new GradeBook("CMPS 251: OO Programming","Zeyad Ali");
		
		gradeBook2.displayMessage();
	}
}
