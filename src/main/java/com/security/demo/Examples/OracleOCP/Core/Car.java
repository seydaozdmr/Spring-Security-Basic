package com.security.demo.Examples.OracleOCP.Core;

public class Car {
    public String make; //instance variable
    public String model;
    public String year;
    public int speed;
    public static int satisAdeti;  //class variable

    //member variable --> instance variable + class variable

    public static int sat(int siparisAdeti){ //siparis adeti local variable
        return satisAdeti+=siparisAdeti;
    }

    public void go(){
        String message="hareket başladı";
        System.out.println(message);
        int speedTemp= getSpeed();
    }

    public int getSpeed(){
        return this.speed;
    }



    {
        int a=5; //local variable (temp - automatic - stack variable) stack'de tutulur
        speed+=a;
    }

}
