package com.security.demo.Examples.OracleOCP.Concurrency;

public class LongWrapperExample {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper wrapper=new LongWrapper(0L);
        Runnable r1=()->{
            for(int i=0;i<1_000;i++){
                wrapper.increment();
            }
        };

//        Thread t1=new Thread(r1);
//        t1.start();
//
//        t1.join(); //thread bitene kadar bekliyor

        Thread [] threads=new Thread[1000];
        for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(r1);
            threads[i].start();
            //1000 adet thread'in aynı anda LongWrapper değerini arttırmaya çalışması race condation'a neden olur
            //bunun çözümü synchronization bloğudur.
        }

        for(int i=0;i<threads.length;i++){
            threads[i].join();
        }

        System.out.println(wrapper.getValue());
    }
}
