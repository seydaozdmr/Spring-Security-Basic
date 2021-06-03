package com.security.demo.Examples.OracleOCP.Core;

public class Car {
    public String make; //instance variable
    public String model;
    public String year;
    public int speed;
    public static int satisAdeti;  //class variable

    //public String speed; farklı türde bile aynı isimde değişken ismi kullanılamaz

    //member variable --> instance variable + class variable

    public static int sat(int siparisAdeti){ //siparis adeti local variable
        return satisAdeti+=siparisAdeti;
    }

    public void go(){
        String message="hareket başladı";
        System.out.println(message);
        int speedTemp= getSpeed();
    }

    //shadowing
    public void saySpeed(){
        int speed=0;
        speed=this.speed;
        System.out.println("speed is : "+speed); //buradaki local variable speed yukardaki member variable'ı gölgeliyor.
    }

    public int getSpeed(){
        return this.speed;
    }



    {
        int a=5; //local variable (temp - automatic - stack variable) stack'de tutulur
        speed+=a;
    }

}
