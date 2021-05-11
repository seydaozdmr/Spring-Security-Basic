package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionExample {
    //we use atomicInteger
    private AtomicInteger sheepCount=new AtomicInteger(0);

    private void inc(){
        synchronized (this){
            System.out.print((sheepCount.incrementAndGet())+" ");
        }
    }

    public static void main(String[] args) {
        ExecutorService service=null;
        try{
            service= Executors.newFixedThreadPool(1);
            RaceConditionExample example=new RaceConditionExample();
                for(int i=0;i<10;i++){
                    service.submit(()-> example.inc());
                }


        }finally {
            if(service!=null) service.shutdown();
        }

    }
}
