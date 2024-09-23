import java.util.ArrayList;

public class P1 {

    public static void main(String[] args){
        ArrayList<String> entities = new ArrayList<String>();

        for (double i = Math.random(); i > .10 ; i = Math.random() ){
            entities.add(String.valueOf(i));
        }

        System.out.println(entities);
    }

}
