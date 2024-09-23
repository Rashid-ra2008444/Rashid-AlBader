package P3;

public class Circle {
	private double radius;
	static double MYPI = 3.14346546;
	public Circle() {
		radius=1;
	}

	public Circle(double radius) {

		this.setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius >= 0 && radius < 20)
			this.radius = radius;
		else
			this.radius=1;
	}
	public double getCircumference() {
		return 2 * Circle.MYPI * this.getRadius();
	}
	public double getArea() {
		return Circle.MYPI * Math.pow(radius, 2);
	}
	
	//Add an instance method called enlarge() that takes a double scaleFactor as parameter and if it is 
	//greater than 1, it multiplies the radius of the circle by this scaleFactor. If the scaleFactor is less 
	//than or equal to 1 it does nothing.
	public void enlarge(double scaleFactor) {
        if (scaleFactor > 1) {
            this.setRadius(this.getRadius() * scaleFactor);
        }
    }

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getCircumference()=" + getCircumference() + ", getArea()=" + getArea()
				+ "]";
	}
	
	
}