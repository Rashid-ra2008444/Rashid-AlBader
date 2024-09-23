package Clients;

public class Company extends Client{
    private String location;
    private int poBox;


    public Company(String companyName,String location , int poBox) {
        super(companyName);
        setLocation(location);
        setPoBox(poBox);
    }

    public String toString() {
        return String.format("Location: %s , PoBox: %d , Company name: %s", getLocation(),getPoBox(),getName());
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPoBox() {
        return poBox;
    }

    public void setPoBox(int poBox) {
        this.poBox = poBox;
    }

    // since discount is final and we cant set it then I make only get and its like this
    public double getDISCOUNT() {
        return 0.35;
    }
}
