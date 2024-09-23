package Clients;

public class Staff extends Client{
    private String jobId;

    public Staff(String name,String jobId) {
        super(name);
        setJobId(jobId);
    }

    public String toString() {
        return String.format("Job ID: %s, Name: %s",getJobId(),getName());
    }


    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        if(jobId != null){
            this.jobId = jobId;
        }
    }

    // since discount is final and we cant set it then I make only get and its like this
    public double getDISCOUNT() {
        return 0.75;
    }
}
