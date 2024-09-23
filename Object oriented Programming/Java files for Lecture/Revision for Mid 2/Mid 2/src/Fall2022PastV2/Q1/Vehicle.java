package Fall2022PastV2.Q1;

public class Vehicle {
    private int plateNo;
    private Owner owner;

    public Vehicle(){}

    public Vehicle(int plateNo){
        setPlateNo(plateNo);
    }

    public Vehicle(int plateNo, Owner owner){
        this(plateNo);
        setOwner(owner);
    }

    public void copy(Vehicle v) {
        v.setOwner(this.owner);
        v.setPlateNo(this.plateNo);
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
}
