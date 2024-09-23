package org.example.q6;

import java.util.ArrayList;

public class Doctor extends SystemUser{
    private String name;
    private String doctorID;
    private double salary;
    private ArrayList<Patient> patients = new ArrayList<Patient>();

    public Doctor(String name, String doctorID, double salary){
        setName(name);
        setDoctorID(doctorID);
        setSalary(salary);
    }

    @Override
    public String getUserID() {
        return getDoctorID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
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
