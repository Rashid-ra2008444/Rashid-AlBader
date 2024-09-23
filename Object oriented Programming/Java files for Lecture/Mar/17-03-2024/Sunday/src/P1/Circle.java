package P1;

public class Circle implements Shape{
    double radius = 2.61;
    @Override
    public double getArea() {
        return 2 * Math.PI*(radius*radius);
    }
}
