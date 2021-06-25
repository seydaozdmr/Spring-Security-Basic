package com.security.demo.Examples.Siniflar.ShapeExample;

public class Rectangle extends Shape {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle is drawing");
    }

    @Override
    public void erase() {
        System.out.println("rectangle is erasing");;
    }

    @Override
    public double calculateArea() {
        return a*b;
    }

    @Override
    public double calculateCircumference() {
        return 2*(a+b);
    }
}
