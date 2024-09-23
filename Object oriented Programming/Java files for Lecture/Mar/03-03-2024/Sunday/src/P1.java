import java.util.Scanner;

public class P1 {

    // teaching composition -- no code written yet
    public static void main(String[] args){
        // This is Quiz 1 code (5.3/6)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your PH level(-999 to quit): ");
        int ph = scanner.nextInt(); // PH IS DOUBLE - NO WAY IT IS INTEGER
        int acidCounter =0;
        int neutralCounter =0;
        int baseCounter =0;

        while(ph !=-999) {
            String phLevel = "";

            // YOU COULD HAVE USED IF IN THIS EXAMPLE. MUCH BETTER THAN SWITCH.
            switch(ph) {
                case 0,1,2,3,4,5,6 : {
                    phLevel = "Acid";
                    acidCounter ++;
                    System.out.printf("%d is %s ",ph,phLevel);
                    break;
                }
                case 7 :{
                    phLevel = "Neutral";
                    neutralCounter ++ ;
                    System.out.printf("%d is %s ",ph,phLevel);
                    break;
                }
                case 8,9,10,11,12,13,14 : {
                    phLevel = "Alkaline";
                    baseCounter ++;
                    System.out.printf("%d is %s ",ph,phLevel);
                    break;
                }
                default : System.out.println("Invalid input should be between 0-14");
            }
            System.out.println("Enter your PH level(-999 to quit): ");
            ph = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Total Acid: "+acidCounter);
        System.out.println("Total Neutral: "+neutralCounter);
        System.out.println("Total Base: "+baseCounter);

    }
}
