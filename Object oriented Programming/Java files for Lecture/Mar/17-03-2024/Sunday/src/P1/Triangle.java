package P1;

public class Triangle implements Shape{
    double base = 7;
    double height = 15;


    @Override
    public double getArea() {
        return base*height;
    }
}
