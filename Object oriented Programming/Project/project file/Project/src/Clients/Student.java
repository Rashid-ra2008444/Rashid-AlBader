package Clients;

public class Student extends Client{
    private int uniRegId;
    private String uniName;

    public Student(int uniRegId, String uniName) {
        super(uniName);
        setUniName(uniName);
        setUniRegId(uniRegId);
    }

    public String toString() {
        return String.format("Student ID : %d , Name : %s", getUniRegId(),getUniName());
    }

    public int getUniRegId() {
        return uniRegId;
    }

    public void setUniRegId(int uniRegId) {
        this.uniRegId = uniRegId;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    // since discount is final and we cant set it then I make only get and its like this
    public double getDISCOUNT() {
        return 0.5;
    }


}
