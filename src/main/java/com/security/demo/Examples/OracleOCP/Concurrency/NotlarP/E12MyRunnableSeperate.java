package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E12MyRunnableSeperate {
    public static void main(String[] args) {
        MyRunnable3 myRunnable3=new MyRunnable3();


        Thread thread=new Thread(myRunnable3,"MyThread 1");
        Thread thread2=new Thread(myRunnable3,"MyThread 2");

        thread.start();
        thread2.start();
    }


}

class MyRunnable3 implements Runnable{
    private int count=0;
    private Object myObject=null;

    public MyRunnable3(){
        this.myObject=new Object();
    }

    @Override
    public void run() {
        System.out.println(myObject);

        for(int i=0;i<1_000_000;i++){
            count++;
        }
        System.out.println(Thread.currentThread().getName()+ " : " +count);
    }
}

