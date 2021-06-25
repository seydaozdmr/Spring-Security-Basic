package com.security.demo.Examples.Siniflar.ShapeExample;

public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();
        //dynamic binding
        Shape shape= shapeFactory.createShape();

        shape.draw();
        shape.erase();

        System.out.println("alan : "+ shape.calculateArea());
        System.out.println("çevre : "+shape.calculateCircumference());

        Shape shape1=new Triangle(3,4,5,4);
        shape1.sayShape(); //early binding, parent's sayShape() method
        shape1.testBinding(); //late binding

        //downcasting shape->Circle general type to specific type
        //runtime type identification (RTTI)
        if(shape instanceof Circle){
            shape.draw();
        }else{
            System.out.println("shape is not Circle");
        }
    }
}
