package Ex3;

public class TwoDShape extends Shape{
	private double width;
	private double height;
	
	public TwoDShape(double width, double height) {
			super();
        setWidth(width);
        setHeight(height);;
	}
	
	public double getWidth() {
        return width;
    }
	public void setWidth(double width) {
        this.width = width;
    }
	public double getHeight() {
        return height;
    }
	public void setHeight(double height) {
        this.height = height;
    }
	
	@Override
	public double getArea() {
        return width * height;
    }
    
   
}
