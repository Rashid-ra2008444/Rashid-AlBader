package Ex1;

public class AC extends EDevice{
    public int temp = 18;

    public AC(int watts , int volt) {
        super(watts,volt);
    }

    @Override
    public void switchOn(){

    }

    @Override
    public void switchOff(){


    }

    @Override
    public String toString(){
        return String.format("%s , temperature: %d",super.toString(),temp);
    }

}
