package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E4ExtendingThread {
    public static void main(String[] args) {
        //start dediğim zaman kendi içindeki run metodunu çalıştırır.
        new Test2().start();
    }
}

class Test2 extends Thread{
    public void run(){
        System.out.println("hello world");
    }
}
