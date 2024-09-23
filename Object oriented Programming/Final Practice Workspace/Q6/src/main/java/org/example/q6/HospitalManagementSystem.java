package org.example.q6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HospitalManagementSystem {
    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    static ArrayList<Patient> patients = new ArrayList<Patient>();

    public void addDoctor(Doctor d){
        doctors.add(d);
    }

    public void addPatient(Patient p){
        patients.add(p);
    }

    public boolean save(){
        ArrayList<DO> DOs = new ArrayList<DO>();
        for(Doctor d : doctors){
            DOs.add(new DO(d.getName(),d.getDoctorID(),TYPE.DOCTOR));
        }
        for(Patient p : patients){
            DOs.add(new DO(p.getPatientName(),p.getPatientID(),TYPE.PATIENT));
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SystemUsers.DB"));
            oos.writeObject(DOs);
            oos.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }

}
