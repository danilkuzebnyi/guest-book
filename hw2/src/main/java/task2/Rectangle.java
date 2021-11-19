package task2;

public class Rectangle implements Shape {

    public double calculateArea() {
        return Input.getA() * Input.getB();
    }

    public double calculatePerimeter() {
        return 2 * (Input.getA() + Input.getB());
    }

    public static double calculateTrianglePerimeter() {
        double hypotenuse = Math.sqrt(Input.getA() * Input.getA() + Input.getB() * Input.getB());
        return Input.getA() + Input.getB() + hypotenuse;
    }
}
