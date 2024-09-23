package P4;

import java.util.ArrayList;

public class HospitalManagmentSystem {
    ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    ArrayList<Patient> patientList = new ArrayList<Patient>();
    public void addDoctor(Doctor doc) {
        doctors.add(doc);
    }

    //write the code for the method to print the total salaries of all doctors.
    public double printTotalSalaries() {
        double sum =0;
        for(Doctor d : doctors) {
            sum += d.getSalary();
        }
        return sum;
    }
    //Write a method to return a reference to the most popular doctor. The most
    //popular doctor is the one who has most appointments. If two doctors have the same
    //number of patients, you may return a reference to any of them. */
    public Doctor getMostPopularDoctor() {
            int max = 0;
            Doctor maxDoctor = null;
                for(Doctor d : doctors){
                    if(d.getPatients().size() > max) {
                        max = d.getPatients().size();
                        maxDoctor = d;
                    }
                }
                return maxDoctor;
    }
}
