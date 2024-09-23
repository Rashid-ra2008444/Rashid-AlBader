import java.util.Arrays;

public class P1 {

    public static void main(String[] args){

        String[] p1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[] p2 = {"k", "l", "m", "n", "o", "p", "q", "r", "s", "t"};
        //before
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));

        System.out.println("--------------------------------");
        System.arraycopy(p1,0,p2,5,5);
        //after
        System.out.println(Arrays.toString(p1));
        System.out.println(Arrays.toString(p2));
    }

}
