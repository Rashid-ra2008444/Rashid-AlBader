package P4;

public class GradeBook {
	
	private String title;
	private int[] grades;
	
	public GradeBook(String title) {
		setTitle(title);
	}
	
	public GradeBook(String title, int[] grades) {
		this(title);
		setGrades(grades);
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int[] getGrades() {
		return grades;
	}
	public void setGrades(int[] grades) {
		this.grades = grades;
	}
	
	

}
