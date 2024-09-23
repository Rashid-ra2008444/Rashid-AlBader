package P7;

public class Vehicle {
    private int plateNo;
    private Owner owner;
    public Vehicle() {}
    public Vehicle(int plateNo) {
        setPlateNo(plateNo);
    }

    public int getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(int plateNo) {
        this.plateNo = plateNo;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void copy(Vehicle v) {
        v.owner = this.owner;
        v.plateNo = this.plateNo;
    }
}
