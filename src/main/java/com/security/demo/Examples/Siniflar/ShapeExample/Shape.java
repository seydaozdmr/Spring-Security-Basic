package com.security.demo.Examples.Siniflar.ShapeExample;

public class Shape {


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

    public double calculateArea(){
        return 0.0; //kare ya da dikdörtgen alanı
    }

    public double calculateCircumference(){
        return 0.0;
    }


}
