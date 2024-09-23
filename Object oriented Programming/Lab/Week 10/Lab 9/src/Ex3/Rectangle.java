package Ex3;

public class Rectangle extends TwoDShape{
	
	public Rectangle(double width, double height) {
		super(width, height);
	}
	
	@Override
    public double getArea() {
        return getWidth() * getHeight();
    }

}
