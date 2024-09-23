package Fall2022PastV2.Q3_4_5;

import java.util.ArrayList;

public class Registration {
    private ArrayList<Transcript> transcripts = new ArrayList<>();
    public Registration() { }

    //Q.3 Write the method m1 that returns a list of Student objects with a CE major who passed a specified course,
    // given its code courseCode, and passed a minimum total number of chs, minChs.
    public ArrayList<Student> m1(String courseCode, int minChs) {
        ArrayList<Student> students = new ArrayList<>();
            for(Transcript t : transcripts){
                if(t.getStudent().getMajor().equals("CE")){
                    int totalChs = 0;
                    boolean coursePassed = false;
                    for(TranscriptEntry te : t.getEntries()) {
                        if(te.getCourse().getCourseCode().equals(courseCode)){
                            if(te.getGrade() >= 60) {
                                coursePassed = true;
                            }
                        }
                        totalChs += te.getCourse().getChs();
                    }
                    if(coursePassed && totalChs >= minChs){
                        students.add(t.getStudent());
                    }
                }
            }
        return students;
    }

    //Q.4 Write the method m2 that calculates the GPA of a student,
    // given the student’s id, id ,
    // using the formula: gpa = Sum(grade*chs)/Sum(chs) and returns the gpa.
    public double m2(String id) {
        double gpa = 0, sum = 0 , sumChs = 0;
        for(Transcript t : transcripts) {
            if(t.getStudent().getId().equals(id)) {
                for(TranscriptEntry te : t.getEntries()){
                    sum += te.getGrade()*te.getCourse().getChs();
                    sumChs += te.getCourse().getChs();
                }
                if(sumChs!= 0)
                    gpa = sum/sumChs;
            }
            break;
        }
        return gpa;
    }


    //Q.5 Write the method m3 that returns an array having
    // the average, of male, female,
    // and all students of CS major who took the course Math 102 in Fall 2021.
    public double[] m3() {
        ArrayList<Student> male = new ArrayList<>();
        ArrayList<Student> female = new ArrayList<>();
        ArrayList<Student> all = new ArrayList<>();
        double[] result = new double[3];
        double avgMale = 0, avgFemale = 0;
        for(Transcript t : transcripts){
            if(t.getStudent().getMajor().equals("CS")){
                for(TranscriptEntry te : t.getEntries()){
                    if(te.getCourse().getCourseTitle().equals("Math102")&&te.getSemester().equals("Fall2021")){
                        all.add(t.getStudent());
                        if(t.getStudent().getGender().equals(Gender.Male)){
                            male.add(t.getStudent());
                        }
                        else {
                            female.add(t.getStudent());
                        }
                    }
                }
            }
        }
        int total = all.size();
        if(!male.isEmpty()) {
            avgMale =  (double) male.size() /total;
        }
        if(!female.isEmpty()) {
            avgFemale =  (double) female.size() /total;
        }
        result[0] = avgMale;
        result[1] = avgFemale;
        result[2] = total;
        return result;
    }
}
