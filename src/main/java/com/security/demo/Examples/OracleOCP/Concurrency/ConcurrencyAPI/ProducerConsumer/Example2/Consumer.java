package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI.ProducerConsumer.Example2;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> blockingQueue=null;

    public Consumer(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                String element=blockingQueue.take();
                System.out.println("consumed : "+element+" by :" + Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
