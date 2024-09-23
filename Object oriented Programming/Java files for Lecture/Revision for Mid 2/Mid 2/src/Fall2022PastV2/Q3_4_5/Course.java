package Fall2022PastV2.Q3_4_5;

public class Course {
    private String courseCode;
    private String courseTitle;
    private int chs;
    public Course() { }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseTitle() { return courseTitle; }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public int getChs() { return chs; }
    public void setChs(int chs) { this.chs = chs; }
}
