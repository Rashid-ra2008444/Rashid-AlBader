package Fall2022PastV2.Q3_4_5;

public class TranscriptEntry {
    private Course course;
    private int grade;//out of 100
    private int year;
    private String semester;
    public TranscriptEntry() {}
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
}
