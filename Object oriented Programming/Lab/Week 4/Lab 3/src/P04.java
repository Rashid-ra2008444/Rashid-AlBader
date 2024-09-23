public class P04 {
    //** . Write a Java program to print numbers between 1 to 100 which are divisible by 3, 5 and by both. ** \\

    public static void main(String[] args) {
        System.out.println("Divided by 3 & 5");
        for(int i = 1; i < 100; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.printf("%d, ",i);
            }
        }

        System.out.println("\nDivided by 3 only");
        for(int i = 1; i < 100; i++) {
            if(i % 3 == 0) {
                System.out.printf("%d, ",i);}
        }

        System.out.println("\nDivided by 5 only");
        for(int i = 1; i < 100; i++) {
            if(i % 5 == 0) {
                System.out.printf("%d, ",i);}
        }
    }
}
