public class P6 {

    public static void main(String[] args){

        int x =5;
        int y = 0;
        // this is like an if statement
        y = x++>5 ? x++ : ++x;
        // this one incrementing first then deal with x
        System.out.println(++x);
        // this one deal with x first then incrementing
        System.out.println(x++);
        System.out.println(x);



    }
}
