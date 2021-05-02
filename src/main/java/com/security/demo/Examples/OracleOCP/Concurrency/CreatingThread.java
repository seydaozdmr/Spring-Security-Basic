package com.security.demo.Examples.OracleOCP.Concurrency;

public class CreatingThread {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();

        Thread t2=new Thread(new MyRunnable());
        t2.start();

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous class's runnable interface");
            }
        };
        Thread t3=new Thread(r1);
        t3.start();

        Runnable r2=()->{
            System.out.println("lambda's runnable interface");
        };
        Thread t4=new Thread(r2);
        t4.start();

    }

    public static class MyThread extends Thread{
        public void run(){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread extended class's thread runs...");
        }
    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Implemented runnable interface's run method");
        }
    }
}
