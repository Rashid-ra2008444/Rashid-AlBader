package Thursday_Practice;

import java.util.ArrayList;

public class Schedule {
    private String term = "fall";
    private int year = 2000;

    public Schedule(String term, int year) {
        setTerm(term);
        setYear(year);
    }
    //Assuming that you are now coding inside the class Schedule,
    // write the code of the method
    //getNumOfFailed which returns the total number of failed students in all sections of the course
    //that has the given course code and taught by the instructor that has the given name.
    public int getNumOfFailed(String instructorName, String courseCode){
        int count = 0;
        for(Section sections : Section.getSections()){
            if(sections.getInstructor().getName().equals(instructorName)&&
               sections.getCourse().getCode().equals(courseCode))
            {
                for(int grade : sections.getGrades()){
                    if(grade < 60) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    //Assuming that you are now coding inside the class Schedule, write the code of the method
    //processUsers which displays the information about each user then if the user is an instructor, it
    //displays the salary while if it is a student is displays the weighted average for that student. At the
    //end, the method displays the message “All done.” followed by the number of processed instructors
    //and the number of processed students.
    public void processUsers(ArrayList<User> users){
      int countInstructors = 0 , countStudent = 0;
      for(User user : users) {
          System.out.println(user);
          if(user instanceof Instructor) {
              Instructor instructor = (Instructor) user;
              System.out.printf("Salary: %.2f",instructor.getSalary());
              countInstructors++;
          }
          else {
              Student student = (Student) user;
              System.out.printf("Average: %.2f",student.getWeightedAvr());
              countStudent++;
          }
          System.out.printf("All Done\n Processed %d Instructors and %d Students",countInstructors,countStudent);
        }
    }


    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
