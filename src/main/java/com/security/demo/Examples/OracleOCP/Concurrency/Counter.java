package com.security.demo.Examples.OracleOCP.Concurrency;

public class Counter {
    private int count=0;

    public boolean inc(){
        if(this.count == 10){
            return false;
        }
        this.count++;
        System.out.println("count ::"+count );
        return true;
    }

    public int getCount(){
        return this.count;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c1=new Counter();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                {
                    c1.inc();
                    System.out.println(Thread.currentThread().getName()+" " +c1.getCount());
                }

            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                {
                    c1.inc();
                    System.out.println(Thread.currentThread().getName()+" " +c1.getCount());
                }

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c1.getCount());
    }
}
