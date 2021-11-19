package task1;

public class Circle extends Shape {
    public final double PI = Math.PI;

    public double calculateArea() {
        return PI * Input.getR() * Input.getR();
    }

    public double calculatePerimeter() {
        return 2 * Input.getR() * PI;
    }
}
