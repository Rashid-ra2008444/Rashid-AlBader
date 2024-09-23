package Thursday_Practice;

import java.util.ArrayList;

public class Section {
    private String code;
    private int capacity = 50;
    private int size = 0;
    private Course course;
    private Instructor instructor;
    private ArrayList<Integer> grades = new ArrayList<Integer>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<Section> sections = new ArrayList<Section>();

    //Assuming that you are now coding inside the class Section, write the code of its constructor.
    public Section(String code, Course course, Instructor instructor) {
        setCode(code);
        setCourse(course);
        setInstructor(instructor);
    }

    @Override
    public String toString() {
        return "Section{" +
                "code='" + code + '\'' +
                ", capacity=" + capacity +
                ", size=" + size +
                ", course=" + course +
                ", instructor=" + instructor +
                ", grades=" + grades +
                ", students=" + students +
                ", sections=" + sections +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public static ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        Section.sections = sections;
    }
}
