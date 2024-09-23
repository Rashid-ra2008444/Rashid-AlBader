import java.util.Random;

public class P2 {
    public static void main(String[] args){
        P1 a = P1.A;
        P1 b = P1.B;

        System.out.println("a.x: " + a.x+", a.y: " + a.y);
        System.out.println("b.x: " + b.x+", b.y: " + b.y);

        a.x+=10;
        b.x-=2;

        System.out.println("a.x: " + a.x+", a.y: " + a.y);
        System.out.println("b.x: " + b.x+", b.y: " + b.y);

        for( P1 i : P1.values()){
            System.out.println(i.x);
            System.out.println(i.y);
        }
        System.out.println("Enum length: "+P1.values().length);
        System.out.println(P1.values()[1].x);
    }
}
