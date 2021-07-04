package com.security.demo.Examples.Siniflar.Exceptions.ShapeExample;

import com.security.demo.Examples.Siniflar.Exceptions.NegativeArgumentException;

import java.util.Random;

public class ShapeFactory {
    private static Random random=new Random();

    public static void main(String[] args) {
        Shape shape=null;
        try {
            shape=produceShape();
        } catch (NegativeArgumentException e) {
            System.out.println(e.getMessage()+ " value : "+e.getValue());
        }

        System.out.println(shape.calculateArea());

        String name="seyda";
        name.length();

    }
    private static Shape produceShape() throws NegativeArgumentException {
        Shape shape=null;

        int i=random.nextInt()%100;
        shape=new Circle(i);
        return shape;
    }
}
