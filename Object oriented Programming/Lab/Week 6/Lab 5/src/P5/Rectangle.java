package P5;

public class Rectangle {
	double width, length;
	
	public double getArea() {
		return getWidth() * getLength();
	}
	
	public Rectangle() {
		
	}
	public Rectangle(double width, double length) {
		setWidth(width);
       setLength(length);
	}
	public Rectangle(double number) {
		setWidth(number);
       setLength(number);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public String toString() {
		return "Width: " + getWidth() + " Length: " + getLength() + " Area: " + getArea();
	}
}
