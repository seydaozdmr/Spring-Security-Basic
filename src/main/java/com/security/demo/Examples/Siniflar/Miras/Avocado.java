package com.security.demo.Examples.Siniflar.Miras;

public class Avocado extends Plant{
    private double tall;


    public static String price="yüksek getirili bitki";

    static {
        System.out.println("********static block in avocado*********");
        System.out.println(price);
        System.out.println("*********en of static avocado**************\n");
    }

    {
        System.out.println("*****initial block in avocado *******");
        System.out.println("avocado initialize edildi.");
        System.out.println("************\n");
    }

    public Avocado(int no,String name,String type,int year,double tall){
        this(no,name,type,year);
        this.tall=tall;
        System.out.println("Avocado full constructor");
    }

    public Avocado(int no, String name, String type, int year) {
        super(no, name, type, year);
        System.out.println("Avocado without tall constructor");
    }

    public static void sayAvocado(){
        System.out.println("**************");
        System.out.println("this is my avocado static method");
        System.out.println("**************");

    }

    public void ilac(){
        System.out.println("avocado çok ilaçlanmaz");
    }

    @Override
    public String toString() {
        return "Avocado{" +
                "tall=" + tall +
                '}';
    }
}
