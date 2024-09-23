package P1;

public class Rectangle implements Shape{
    double length = 17.5;
    double width = 35.5;

    @Override
    public double getArea() {
        return length * width;
    }



}
