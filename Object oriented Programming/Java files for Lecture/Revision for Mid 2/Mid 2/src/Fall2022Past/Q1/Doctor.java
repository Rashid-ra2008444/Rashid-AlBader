package Fall2022Past.Q1;

import java.util.ArrayList;

public class Doctor {
    private String name;
    private int id;
    private double salary;
    // a list of patients the doctor currently assigned to.
    ArrayList<Patient> patients=new ArrayList<Patient>();
    public void addPatient(Patient p){
        patients.add(p);
    }
    public Doctor(String name, int id,int salary) {
        setName(name);
        setId(id);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
