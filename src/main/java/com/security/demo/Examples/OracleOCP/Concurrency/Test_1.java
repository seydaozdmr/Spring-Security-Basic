package com.security.demo.Examples.OracleOCP.Concurrency;

public class Test_1 {
    public static void main(String[] args) {
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                try {
                    String name=SingletonExmple.getName("hatice");
                    System.out.println(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 started");
            }
        };

        Runnable r2=new Runnable() {
            @Override
            public void run() {
                try {
                    String name=SingletonExmple.getName("seyda");
                    System.out.println(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2 started");
            }
        };

        Thread t3=new Thread(()-> System.out.println("yeni thread"));

        Thread t1=new Thread(r1);
        t1.start();

        Thread t2=new Thread(r2);
        t2.start();

        t3.start();


    }
}
