package com.security.demo.Examples.OracleOCP.Interfaces;

public interface Liquid {

    public default void prepare(){
        System.out.println("drink is preparing");
    }
    //abstract method
    int measure();

    //static method
    public static void d(){}

    //same exist in AbstractProduct class
    void e();


}
