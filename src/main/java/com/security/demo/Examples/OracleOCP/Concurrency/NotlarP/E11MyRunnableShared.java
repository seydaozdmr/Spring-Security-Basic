package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E11MyRunnableShared {
    public static void main(String[] args) {
        MyRunnable2 myRunnable2=new MyRunnable2();

        Thread t1=new Thread(myRunnable2,"Thread - 1");
        Thread t2=new Thread(myRunnable2,"Thread - 2");
        t1.start();
        t2.start();
    }
}

class MyRunnable2 implements Runnable{
    //nesneye ait bir değişken olduğu için heap alanında yaratılır ve iki thread de aynı anda erişebilir
    private int count = 0;
    @Override
    public void run() {
        //Thread çalıştırıldığında bir obje yaratırsa
        Object obj=new Object();
        System.out.println(obj);
        for(int i=0;i<1_000_000;i++){
            this.count++;
        }
        System.out.println(Thread.currentThread().getName() + " : "+this.count);
    }
}
