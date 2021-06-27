package com.security.demo.Examples.Siniflar.ShapeExample;

public abstract class Shape {


    public void draw(){
        System.out.println("shape is drawing");
    }

    public void erase(){
        System.out.println("shape is erasing");
    }

    protected void testBinding(){
        System.out.println("this is shape's testbinding..");
    }

    //this static method can not override in child classes
    public static void sayShape(){
        System.out.println("this is parent shape... it has bind at compile time");
    }

    //this method can not override beacuse private
    private void process(){
        System.out.println("shape is creating");
    }

    public abstract double calculateArea();

    public abstract double calculateCircumference();


}
