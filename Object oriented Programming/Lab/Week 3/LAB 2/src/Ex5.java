import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 for finding the month in number and 2 for finding the name of the month by number");
        int choose = scanner.nextInt();
        scanner.nextLine();
        if(choose == 1){
            System.out.println("Enter the month name: ");
            String monthName = scanner.nextLine().trim().toLowerCase();
                switch (monthName) {
                    case "january":     System.out.println(1);break;
                    case "february":    System.out.println(2);break;
                    case "march":       System.out.println(3);break;
                    case "april":       System.out.println(4);break;
                    case "may":         System.out.println(5);break;
                    case "june":        System.out.println(6);break;
                    case "july":        System.out.println(7);break;
                    case "august":      System.out.println(8);break;
                    case "september":   System.out.println(9);break;
                    case "october":     System.out.println(10);break;
                    case "november":    System.out.println(11);break;
                    case "december":    System.out.println(12);break;
                    default:            System.out.println("Invalid name");
                }
        }
        else if(choose ==2){
            System.out.println("Enter the month number");
            int monthNum = scanner.nextInt();
            switch (monthNum){
                case 1: System.out.println("January"); break;
                case 2: System.out.println("February"); break;
                case 3: System.out.println("March"); break;
                case 4: System.out.println("April"); break;
                case 5: System.out.println("May"); break;
                case 6: System.out.println("June"); break;
                case 7: System.out.println("July"); break;
                case 8: System.out.println("August"); break;
                case 9: System.out.println("September"); break;
                case 10:System.out.println("October"); break;
                case 11:System.out.println("November"); break;
                case 12:System.out.println("December"); break;
                default:System.out.println("Invalid"); break;
            }
        }
        else {
            System.out.println("Invalid input");
        }
    }
}
