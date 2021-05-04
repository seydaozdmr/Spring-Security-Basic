package com.security.demo.Examples.OracleOCP.Concurrency;

public class RaceConditionExample {
    public static void main(String[] args) {
        Counter2 c1=new Counter2();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1_000_000;i++){
                    c1.incAndGet();
                }
                System.out.println("Thread 1 : "+c1.get());
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1_000_000;i++){
                    c1.incAndGet();
                }
                System.out.println("Thread 2 : "+c1.get());
            }
        });
        Thread t3=new Thread(runnable1(c1));

        t1.start();
//        t2.start();
        t3.start();
    }

    public static Runnable runnable1(Counter2 counter){
        return ()->{
          for(int i=0;i<10;i++){
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("Thread 3 count : "+counter.get());
          }
        };
    }

}
class Counter2{
    private int count=0;

    public int incAndGet(){
        synchronized (this){
            this.count++;
        }
        return this.count;
    }

    public int get(){
        return this.count;
    }
}
