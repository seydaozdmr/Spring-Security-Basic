package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> blockingQueue=null;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            long timeMilis=System.currentTimeMillis();
            try{
                this.blockingQueue.put(""+timeMilis);

            }catch (InterruptedException e){

            }
            sleep(100);
        }
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
