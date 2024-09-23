
public class P4 {
	
	public static double Hypothesis(double a , double b) {
		double c;
		c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		return c;
	}
	
	public static void main(String[] args) {
        double triangle1 = Hypothesis(3, 4);
        double triangle2 = Hypothesis(5,12);
        double triangle3 = Hypothesis(8, 15);
        System.out.println(triangle1);
        System.out.println(triangle2);
        System.out.println(triangle3);;
	}

}
