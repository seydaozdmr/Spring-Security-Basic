package com.security.demo.Examples.OracleOCP.Interfaces;

public interface Testable {

     //all abstract methods access modifier public - implicitly
     int a = 5;
     public default void prepare(){
          System.out.println("drink is preparing");
     }
     //abstract methods:
     int measure();
     void consume(int quantity);


     //static method
     public static void d(){}


}
