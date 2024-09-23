package Ex1;

public abstract class EDevice {
    private int watts;
    private int volt;

    public EDevice(int watts, int volt) {
        this.watts = watts;
        this.volt = volt;
    }

    public abstract void switchOn() ;

    public abstract void switchOff();

    public String toString(){
        return String.format("Watts: %d , Voltage: %d",watts,volt);
    }
}
