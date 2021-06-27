package com.security.demo.Examples.Siniflar.ShapeExample;

public class ShapeFactory {
    public ShapeFactory() {
    }

    public Shape createShape(){
        Shape shape=null;

        int i=(int) (5* Math.random());

        switch (i){
//            case 0:{
//                //shape=new Shape();
//                break;
//            }
            case 1:{
                shape=new Circle(5.0);
                break;
            }
            case 2:{
                shape=new Rectangle(3,6);
                break;
            }
            case 3:{
                shape=new Square(3.6);
                break;
            }
            case 4:{
                shape=new Triangle(3,4,5,4);
                break;
            }
            default:{
                break;
            }
        }
        return shape;
    }
}
