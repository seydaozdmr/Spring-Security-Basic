package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI.ProducerConsumer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        BlockingQueue<String> queue=new ArrayBlockingQueue<>(3);

        Producer p=new Producer(queue);
        Consumer c=new Consumer(queue);

//        Thread t1=new Thread(p);
//        Thread t2=new Thread(c);
//
//        t1.start();
//        t2.start();

        ExecutorService service= Executors.newFixedThreadPool(2);
        service.execute(p);
        service.execute(c);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
        service.shutdown();
    }
}
