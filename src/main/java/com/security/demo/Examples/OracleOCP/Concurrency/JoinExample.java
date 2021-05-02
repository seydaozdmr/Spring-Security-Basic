package com.security.demo.Examples.OracleOCP.Concurrency;

public class JoinExample {
    public static void main(String[] args) {
        Runnable r1=()->{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };

        Thread t1=new Thread(r1);
        t1.setDaemon(true);
        t1.start();

        //while main thread stops t1 stops immediately
        try {
            t1.join(); //t1. bitmeden main thread bitirilmez
            //main thread stops until t1 stops
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
