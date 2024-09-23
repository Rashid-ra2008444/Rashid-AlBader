public class P5 {
    //this code show how to call a function outside the main function
    static void display10tt(){
        for(int i= 1; i <=10 ; i++){
            for(int j= 1; j<=10 ; j++){
                System.out.printf("%3d\t\t", i*j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
    display10tt();
    }
}
