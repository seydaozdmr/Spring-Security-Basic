package com.security.demo.Examples.OracleOCP.Concurrency;

public class ConsumerProducer {
    private static int[] buffer;
    private static  int count;
    private static Object lock=new Object();

    static class Produce{
        void produce() throws InterruptedException {
            synchronized (lock){
                if(isFull(buffer)) {
                    lock.wait();
                }
                buffer[count++] =1;
                lock.notify();
            }

        }
    }

    static class Consumer{
        void consume() throws InterruptedException {
            synchronized (lock){
                if(isEmpty(buffer)){
                    lock.wait();
                }
                buffer[--count]=0;
                lock.notify();
            }

        }
    }

    static boolean isEmpty(int [] buffer){
        return count==0;
    }

    static boolean isFull(int [] buffer){
        return count==buffer.length;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer=new int [10];
        count=0;

        Produce produce=new Produce();
        Consumer consumer=new Consumer();

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++){
                    try {
                        produce.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Done producing");
            }
        };

        Runnable r2=()->{
          for(int i=0;i<45;i++){
              try {
                  consumer.consume();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
            System.out.println("done consuming");
        };

        Thread consumerThread=new Thread(r2);
        Thread producerThread=new Thread(r1);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("all done remains: "+count);

    }
}
