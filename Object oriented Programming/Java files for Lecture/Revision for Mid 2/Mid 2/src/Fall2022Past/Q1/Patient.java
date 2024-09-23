package Fall2022Past.Q1;

import java.util.ArrayList;
import java.util.Random;

public class Patient {

    private String patientName;
    private String patientCode; // unique identification number consisting of 10 digits
    private String address;
    private int age;
    private boolean highPriority; // true if high priority, false if not
    static ArrayList<String> codeList=new ArrayList<String>();
    public Patient(String patientName, String address, int age) {
        setPatientName(patientName);
        this.patientCode = generatePatientCode();
        setAddress(address);
        setAge(age);
        highPriority=false;
    }
    ///*TODO 1: Create the method to generate the patientCode, which consists
    //of 10 randomly generated numbers.
    //The generated code should be unique for each patient. */
    private String generatePatientCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHighPriority() {
        return highPriority;
    }

    public void setHighPriority(boolean highPriority) {
        this.highPriority = highPriority;
    }

    public static ArrayList<String> getCodeList() {
        return codeList;
    }

    public static void setCodeList(ArrayList<String> codeList) {
        Patient.codeList = codeList;
    }
}
