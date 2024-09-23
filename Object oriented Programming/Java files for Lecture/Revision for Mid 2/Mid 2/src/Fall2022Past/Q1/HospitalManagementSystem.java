package Fall2022Past.Q1;

import java.util.ArrayList;

public class HospitalManagementSystem {

    ArrayList<Doctor> doctors=new ArrayList<Doctor>();
    ArrayList<Patient> patientList=new ArrayList<Patient>();
    public void addDoctor(Doctor doc)
    {
        doctors.add(doc);
    }
    //TODO 2: write the code for the method to print the total salaries of all doctors.
    public double printTotalSalaries(){
        double total=0;
        for(Doctor d : doctors) {
            total+= d.getSalary();
        }
        return total;
    }

    /* TODO 3: Write a method to return a reference to the most popular doctor. The most
    popular doctor is the one who has most appointments. If two doctors have the same
    number of patients, you may return a reference to any of them.*/
    public Doctor mostPopularDoctor() {
        Doctor mostPopular=null;
        int max=0;
        for(Doctor d : doctors) {
            if(d.getPatients().size()>max) {
                max=d.getPatients().size();
                mostPopular=d;
            }
        }
        return mostPopular;
    }

    public static void main(String[] args)
    {
        HospitalManagementSystem system=new HospitalManagementSystem();
        Patient p=new Patient("Mohammed","Qatar",77);
        Patient p1=new Patient("Yuki","Japan",40);
        Patient p2=new Patient("Nusret","Turkey",50);
        Patient p3=new Patient("Michael","USA",20);
        Patient p4=new Patient("Ali","Iran",66);
        Patient p5=new Patient("Rabeh","Algeria",60);
        Patient p6=new Patient("Mathews","Australia",50);
        Patient p7=new Patient("Rashid","Jordan",199);
        Doctor d1=new Doctor("Amal", 50,500);
        system.addDoctor(d1);
        // Assigning patients to d1
        d1.addPatient(p);
        d1.addPatient(p1);
        d1.addPatient(p2);
        Doctor d2=new Doctor("Omar", 50,500);
        system.addDoctor(d2);
        // Assigning patients to d2
        d2.addPatient(p4);
        d2.addPatient(p5);
        d2.addPatient(p6);
        d2.addPatient(p7);
        Doctor d3=new Doctor("Eman", 50,400);
        system.addDoctor(d3);
        // Assigning patients to d3
        d3.addPatient(p3);
        d3.addPatient(p4);
        d3.addPatient(p5);
        d3.addPatient(p6);
        d3.addPatient(p7);
        // printing total salaries of the doctors
        system.printTotalSalaries();
        // Printing the name of the most popular doctor.
        System.out.print("The Most popular Doctor is: ");
        Doctor mostpopular= system.mostPopularDoctor();
        System.out.println(mostpopular.getName());
    }

}
