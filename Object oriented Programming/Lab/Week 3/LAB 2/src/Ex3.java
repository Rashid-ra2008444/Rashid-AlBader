public class Ex3 {
    public static void main(String[] args){
        System.out.println("Fahrenheit\tCentigrade");

        for(int fahr = 0 ; fahr <= 100 ; fahr+=10){
            double centigrade = (double) (5 * (fahr - 32)) /9;
           System.out.printf("%10d\t%10.3f\n",fahr,centigrade);

        }
    }

}
