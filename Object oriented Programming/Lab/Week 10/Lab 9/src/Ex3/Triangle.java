package Ex3;

public class Triangle extends TwoDShape{
	
	public Triangle(double width, double height) {
        super(width, height);
        
    }
	
	@Override
	public double getArea() {
        return 0.5 * super.getWidth() * super.getHeight();
    }
	
	

}
