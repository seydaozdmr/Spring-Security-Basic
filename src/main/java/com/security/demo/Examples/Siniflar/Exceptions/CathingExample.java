package com.security.demo.Examples.Siniflar.Exceptions;

public class CathingExample {
    public static void main(String[] args) {
        try{
            doSomething();
            //if exception throws we can't see this message... try goes to catch...
            System.out.println("After doSomething without any exception..");
        }catch (Throwable t){
            System.out.println(t.getMessage());
        }
        System.out.println("After doSomething() 2! ");
    }

    private static void doSomething() throws Throwable {
        doSomethingElse();
    }

    private static void doSomethingElse() throws Throwable {
        throwAThrowable();
    }

    private static void throwAThrowable() throws Throwable {
        double random=Math.random();
        if(random<0.5){
            System.out.println("I have a problem while i'm doing my work random : "+random);
            Throwable throwable=new Throwable("Fırlatılan istisna");
            throw throwable;
        }else {
            System.out.println("I'm doing my work without any problem at random :"+random);
        }
    }
}
