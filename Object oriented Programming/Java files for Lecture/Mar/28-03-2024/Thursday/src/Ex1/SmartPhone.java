package Ex1;

public class SmartPhone extends EDevice implements Radio{

    public double channel = 87.5;
    public boolean on = false;
    public boolean radioOn = false;

    public SmartPhone(int watts, int volt) {
        super(watts,volt);
    }
    public String toString() {
        return String.format("%s, Channel: %.2f", super.toString(),channel);
    }

    @Override
    public void switchOn(){


    }

    @Override
    public void switchOff(){

    }

    @Override
    public void onRadio() {

    }

    @Override
    public void offRadio() {

    }

    @Override
    public void switchChannel(double frequency) {

    }
}
