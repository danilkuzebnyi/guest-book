package task2;

public class Circle implements Shape {
    public final double PI = Math.PI;

    public double calculateArea() {
        return PI * Input.getR() * Input.getR();
    }

    public double calculatePerimeter() {
        return 2 * Input.getR() * PI;
    }
}
