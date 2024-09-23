public class P02 {
    //** Write a Java program to swap two variables.** \\
    public static void main(String[] args) {

        int a = 10 ;
        int b = 20 ;

        System.out.println("Before swapping");
        System.out.println("a= "+a);
        System.out.println("b= "+b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("After swapping");
        System.out.println("a= "+a);
        System.out.println("b= "+b);

    }
}
