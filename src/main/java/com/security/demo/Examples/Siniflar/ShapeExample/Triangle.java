package com.security.demo.Examples.Siniflar.ShapeExample;

public class Triangle extends Shape{
    private int a;
    private int b;
    private int c;
    private int h;

    public Triangle(int a, int b, int c, int h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    protected void testBinding() {
        System.out.println("this is tiangle's test binding method.");
    }

    @Override
    public void draw() {
        System.out.println("Triangle is drawing");
    }

    @Override
    public void erase() {
        System.out.println("triangle is erasing");;
    }

    @Override
    public double calculateArea() {
        return a*h*0.5;
    }

    @Override
    public double calculateCircumference() {
        return a+b+c;
    }
}
