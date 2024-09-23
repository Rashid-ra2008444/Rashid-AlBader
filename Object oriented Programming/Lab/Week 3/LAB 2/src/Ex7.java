public class Ex7 {
    public static void main(String[] args){
        for(int inches = 0; inches <= 50 ; inches+=2 ){
           double centimeter = (double) 2.54*inches;
           System.out.printf("%.2f\n",centimeter);
        }
    }
}
