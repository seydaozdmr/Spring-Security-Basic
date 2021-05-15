package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E5ThreadSleep {
    public static int count=0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            for(int i=0;i<1_000_000;i++){
                count++;
            }
        }).start();

        while(count<1_000_000){
            System.out.println("henüz bitmedi");
            Thread.sleep(1000);
        }

        System.out.println("bitti.");

        //2:
        Runnable runnable=()->{
            System.out.println(Thread.currentThread().getName()+" running");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" finished");
        };
        Thread thread=new Thread(runnable,"BenimThreadim");
        thread.start();

    }
}
