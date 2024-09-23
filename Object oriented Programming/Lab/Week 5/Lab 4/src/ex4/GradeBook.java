package ex4;

public class GradeBook {
	
	private String courseName;
	private String instructor;
	
	
	public GradeBook(String courseName , String instructor) {
		setCourseName(courseName);
		setInstructor(instructor);
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public void displayMessage() {
		System.out.printf("Welcome to the grade book for \n%s!\nYour Instructor is %s\n",getCourseName(),getInstructor());
	}
}
