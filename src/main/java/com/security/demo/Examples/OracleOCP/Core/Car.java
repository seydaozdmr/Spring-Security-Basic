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

    {
        int a=0; //local variable (temp - automatic - stack variable)
        speed+=a;
    }

}
