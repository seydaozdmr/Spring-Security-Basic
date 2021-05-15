package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E14Synchronized {

    public static void main(String[] args) {
        MyRunnable5 myRunnable5=new MyRunnable5();
        Thread thread=new Thread(myRunnable5,"MyThread -1 ");
        Thread thread1=new Thread(myRunnable5,"MyThread -2");
        thread.start();
        thread1.start();

    }
}

class MyRunnable5 implements Runnable{
    private int count=0;

    @Override
    public void run() {

        synchronized (this){
            for(int i=0;i<1_000_000;i++){
                count++;

            }
        }

        System.out.println(Thread.currentThread().getName()+ " : " +count);

    }
}
