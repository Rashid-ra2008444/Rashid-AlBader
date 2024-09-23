public class P4 {
    public static void main(String[] args){
        // this code shows nested loop meaning loop inside loop
        for(int i= 0; i <=3 ; i++){
            for(int j= 0; j<=2 ; j++){
                System.out.printf("%d,%d\t\t", i, j);
            }
            System.out.println();
        }
        // this code shows the multiplication table from nested loop
        for(int i= 1; i <=10 ; i++){
            for(int j= 1; j<=10 ; j++){
                System.out.printf("%3d\t\t", i*j);
            }
            System.out.println();
        }
    }
}
