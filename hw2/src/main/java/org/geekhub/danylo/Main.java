package org.geekhub.danylo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the figure what will be calculated: ");
        String figure = in.nextLine();
        if ("circle".equalsIgnoreCase(figure)) {
            System.out.print("Enter the radius: ");
            Input.setR(in.nextDouble());
            System.out.println("The area of circle is: " + circle.calculateArea());
            System.out.println("The perimeter of circle is: " + circle.calculatePerimeter());
        } else if ("square".equalsIgnoreCase(figure)) {
            System.out.print("Enter the side length: a = ");
            Input.setA(in.nextDouble());
            System.out.println("The area of square is: " + square.calculateArea());
            System.out.println("The perimeter of square is: " + square.calculatePerimeter());
            System.out.println("The area of triangle in the square is: " + square.calculateArea() / 2);
            System.out.println("The perimeter of triangle in the square is: " + square.calculateTrianglePerimeter());
        } else if ("rectangle".equalsIgnoreCase(figure)) {
            System.out.print("Enter the sides length:\na = ");
            Input.setA(in.nextDouble());
            System.out.print("b = ");
            Input.setB(in.nextDouble());
            System.out.println("The area of rectangle is: " + rectangle.calculateArea());
            System.out.println("The perimeter of rectangle is: " + rectangle.calculatePerimeter());
            System.out.println("The area of triangle in the rectangle is: " + rectangle.calculateArea() / 2);
            System.out.println("The perimeter of triangle in the rectangle is: " + rectangle.calculateTrianglePerimeter());
        } else if ("triangle".equalsIgnoreCase(figure)) {
            System.out.print("Enter the sides length:\na = ");
            Input.setA(in.nextDouble());
            System.out.print("b = ");
            Input.setB(in.nextDouble());
            System.out.print("c = ");
            Input.setC(in.nextDouble());
            System.out.println("The area of triangle is: " + triangle.calculateArea());
            System.out.println("The perimeter of triangle is: " + triangle.calculatePerimeter());
        }
    }
}