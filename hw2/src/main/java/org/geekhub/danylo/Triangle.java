package org.geekhub.danylo;

public class Triangle extends Shape {

    public double calculateArea() {
        double p = (Input.getA() + Input.getB() + Input.getC()) / 2;
        return Math.sqrt(p * (p - Input.getA()) * (p - Input.getB()) * (p - Input.getC()));
    }

    public double calculatePerimeter() {
        return Input.getA() + Input.getB() + Input.getC();
    }
}
