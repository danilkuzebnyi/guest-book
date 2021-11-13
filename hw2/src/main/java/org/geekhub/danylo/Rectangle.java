package org.geekhub.danylo;

public class Rectangle extends Shape {

    public double calculateArea() {
        return Input.getA() * Input.getB();
    }

    public double calculatePerimeter() {
        return 2 * (Input.getA() + Input.getB());
    }

    public double calculateTrianglePerimeter() {
        double hypotenuse = Math.sqrt(Input.getA() * Input.getA() + Input.getB() * Input.getB());
        return Input.getA() + Input.getB() + hypotenuse;
    }
}
