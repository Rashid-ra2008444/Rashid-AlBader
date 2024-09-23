public class P2 {
    // write a function sum to return the sum of 2 numbers to n
    public static int sum2(int x , int y){
        return x+y;
    }

    //write a function sum to return the sum of 3 numbers to n

    public static int sum3(int x , int y, int z){
        return x+y+z;
    }

    //write a function sum to return the sum of 4 numbers to n;

    public static int sum4(int x , int y , int z, int w){
        return x+y+z+w;
    }

    public static void main(String[] args){

        System.out.println("Sum of 2: "+sum2(8,9));
        System.out.println("Sum of 3: "+sum3(8,9,10));
        System.out.println("Sum of 4: "+sum4(8,9,10,11));
    }
}
