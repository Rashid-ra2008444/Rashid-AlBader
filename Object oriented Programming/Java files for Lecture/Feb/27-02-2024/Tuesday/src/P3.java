public class P3 {

    public static double average(double... numbers) {
        double total =0 ;
        for (var num : numbers) {
            total += num;
        }

        return total / numbers.length;
    }

    public static void main(String[] args) {
        double avg = average(5,7,3,1,5,7);

        System.out.println("Average: " + avg);
    }
}
