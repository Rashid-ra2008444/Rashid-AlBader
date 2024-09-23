package Thursday_Practice;

public class Student extends User{
    private String major;
    private final int MAX = 6;

    private int[] grades = new int[MAX];
    private Course[] courses = new Course[MAX];

    public Student(String name, String username, String major) {
        super(name, username);
        setMajor(major);
    }
//When overriding toString, take advantage of calling the toString of the super class.
    @Override
    public String toString() {
        return String.format("%sMajor: %s\n",super.toString(),major);
    }

//The method getGrade returns the grade of the given course title for this student. Note that
//this class keeps information on courses taken by the student and their corresponding
//grades in the arrays courses and grades respectively.
    public double getGrade(String courseTitle){
        int grade = -1;

        for(int i = 0; i < grades.length; i++){
            if(courses[i].getTitle().equals(courseTitle)){
                grade = grades[i];
                break;
            }
        }
        return grade;
    }
    //The method getWeightedAvr returns calculates the weighted average of the courses taken
    //by the student and returns it. weighted average is the sum of the grade*chs for all courses
    //divided by the sum of the chs for all courses.
    public double getWeightedAvr(){
        double sum = 0;
        double sumChs = 0;
        for(int i = 0; i < grades.length; i++){
            sum += grades[i]*courses[i].getChs();
            sumChs += courses[i].getChs();
        }
        return sum/sumChs;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getMAX() {
        return MAX;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
}
