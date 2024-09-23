import java.util.Arrays;

public class P12 {
    public static void main(String[] args){
        String name = "rashid";
        String DoB = "13-07-2002";
        String QUID = "202008444";

        String[] DObSplitter =DoB.split("-");

        System.out.println(Arrays.toString(DObSplitter));



    }

}
