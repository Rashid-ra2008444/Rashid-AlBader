public class P09 {
    //** Write a program that generates multiplication tables for the numbers 0 through 12.**\\

    public static void main(String[] args) {
        for(int i = 0 ; i <=12 ; i++) {
            for(int j =0 ; j <=12; j++) {
                System.out.printf("%d X %d = %d\n",i,j,i*j);
            }
        }
    }
}
