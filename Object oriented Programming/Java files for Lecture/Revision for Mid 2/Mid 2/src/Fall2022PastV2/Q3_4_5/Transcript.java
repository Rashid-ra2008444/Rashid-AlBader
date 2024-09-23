package Fall2022PastV2.Q3_4_5;

import java.util.ArrayList;

public class Transcript {
    private Student student;
    private ArrayList<TranscriptEntry> entries = new ArrayList<TranscriptEntry>();
    public Transcript() {
// TODO Auto-generated constructor stub
    }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public ArrayList<TranscriptEntry> getEntries() { return entries; }
    public void setEntries(ArrayList<TranscriptEntry> entries) {
        this.entries = entries;
    }
}
