package P4;

import java.util.ArrayList;
import java.util.Random;

public class Patient {
    private String patientName;
    private String patientCode; // unique identification number consisting of 10 digits
    private String address;
    private int age;
    private boolean highPriority; // true if high priority, false if not
    static ArrayList<String> codeList = new ArrayList<String>();

    public Patient(String patientName, String address, int age) {
        this.patientName = patientName;
        this.patientCode = generatePatientCode();
        this.address = address;
        this.age=age;
        highPriority=false;
    }
    //Create the method to generate the patientCode, which consists
    //of 10 randomly generated numbers.
    //The generated code should be unique for each patient. */
    private  String generatePatientCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
