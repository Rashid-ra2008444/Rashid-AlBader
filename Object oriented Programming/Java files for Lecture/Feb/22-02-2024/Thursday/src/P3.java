import java.util.Random;

public class P3 {

    public static void main(String[] args) {
        Random rand = new Random();

        int n = 100000;
        int counter =0;
        for (int i = 0; i < n; i++){
            int x = rand.nextInt(1,7);
            int y = rand.nextInt(0,2);

            if(x==3 && y== 1){
                counter ++;
            }
        }
        System.out.println("P(3,T): " +(double) counter/n);

    }
}
