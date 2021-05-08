package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI.ProducerConsumer.Example2;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue<String> blockingQueue=null;

    public Producer(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    @Override
    public void run() {

        int count=0;
        while(true){
            String threadName=Thread.currentThread().getName() + count++;

            try{
                this.blockingQueue.put(threadName);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            sleep(1000);
        }

    }

    private void sleep(int i) {
        try{
            Thread.sleep(i);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
