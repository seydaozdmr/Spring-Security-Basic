package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<String> blockingQueue=null;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                String element=blockingQueue.take(); //eğer kuyrukta hiç bir eleman yoksa thread bloklanır ve bekler
                System.out.println("consumed : "+element);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
