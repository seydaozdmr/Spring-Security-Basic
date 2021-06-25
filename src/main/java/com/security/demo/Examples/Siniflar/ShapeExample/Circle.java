package com.security.demo.Examples.Siniflar.ShapeExample;

public class Circle  extends Shape{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    //this is not Overriding , this is shadowing or hiding... because of static keyword
    public static void sayShape(){
        System.out.println("this is Circle");
    }

    //this is not parent's process method. this method created again.
    public void process(){
        System.out.println("Circle is creating");
    }

    @Override
    public void draw() {
        System.out.println("Circle is drawing");;
    }

    @Override
    public void erase() {
        System.out.println("Circle is erasing");;
    }

    @Override
    public double calculateArea() {
        return Math.PI*r*r; //a is r;
    }

    @Override
    public double calculateCircumference() {
        return 2*Math.PI*r; //a is r;
    }
}
