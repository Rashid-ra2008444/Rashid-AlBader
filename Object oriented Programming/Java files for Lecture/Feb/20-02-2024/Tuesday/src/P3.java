import java.util.ArrayList;

public class P3 {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++)   {
            numbers.add(i);
            System.out.println(numbers);
            System.out.println("Current ArrayList size -> "+numbers.size());
        }


    }
}
