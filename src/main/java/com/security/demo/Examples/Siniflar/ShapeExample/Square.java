package com.security.demo.Examples.Siniflar.ShapeExample;

public class Square extends Shape{
    private double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public void draw() {
        System.out.println("Square is drawing");
    }

    @Override
    public void erase() {
        System.out.println("Square is erasing");;
    }

    @Override
    public double calculateArea() {
        return a*a;
    }

    @Override
    public double calculateCircumference() {
        return 4*a;
    }
}
