package com.security.demo.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static com.security.demo.Threads.ProducerExample.EOF;

public class ProducerExampleReenterantLock {
    public static final String EOF="EOF";
    public static void main(String[] args) {
        List<String> buffer=new ArrayList<>();
        ReentrantLock bufferLock=new ReentrantLock();
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        MyProducer2 myProducer=new MyProducer2(buffer,ThreadColor.ANSI_BLUE,bufferLock);
        MyConsumer2 myConsumer=new MyConsumer2(buffer,ThreadColor.ANSI_PURPLE,bufferLock);
        MyConsumer2 myConsumer1=new MyConsumer2(buffer,ThreadColor.ANSI_RED,bufferLock);
        MyConsumer2 myConsumer2=new MyConsumer2(buffer,ThreadColor.ANSI_BLACK,bufferLock);
        MyConsumer2 myConsumer3=new MyConsumer2(buffer,ThreadColor.ANSI_CYAN,bufferLock);

        executorService.execute(myProducer);
        executorService.execute(myConsumer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);
        executorService.execute(myConsumer3);
        //eğer işlem bittikten sonra executorService'i kapatmazsak thread pool çalışmaya devam eder
        executorService.shutdown();
//        new Thread(myProducer).start();
//        new Thread(myConsumer).start();
//        new Thread(myConsumer1).start();
//        new Thread(myConsumer2).start();
//        new Thread(myConsumer3).start();
    }
}

class MyProducer2 implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public MyProducer2(List<String> buffer, String color ,ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock=reentrantLock;
    }

    @Override
    public void run() {
        Random random=new Random();
        List<String> nums=generateNums();
//        String [] nums={"1","2","3","4","5"};

        for(String num:nums){
            System.out.println(color+"Thread:"+Thread.currentThread().getName()+" Adding .. "+num);
            //buffer nesnesini yani arrayList'i synchronized yaptık...
            reentrantLock.lock();
            try{
                buffer.add(num);
            }finally {
                reentrantLock.unlock();
            }
            try{
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println(color+" Adding EOF and exiting....");
        reentrantLock.lock();
        try{
            buffer.add("EOF");
        }finally {
            reentrantLock.unlock();
        }
    }

    private List<String> generateNums() {
        Random random=new Random();
        List<String> nums=new ArrayList<>();
        for(int i=0;i<10000;i++){
            nums.add(String.valueOf(random.nextInt(10000)));
        }
        return nums;
    }
}

class MyConsumer2 implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock reentrantLock;

    public MyConsumer2(List<String> buffer, String color,ReentrantLock reentrantLock) {
        this.buffer = buffer;
        this.color = color;
        this.reentrantLock=reentrantLock;
    }

    @Override
    public void run() {
        //thread kod bloğunu işleme alana kadar geçen süreyi hesaplamak için
        int counter=0;
        while(true){
            //eğer lock durumundaysa if bloğu çalışacak ve unlock gerçekleşecek
            if(reentrantLock.tryLock()){
                try{
                    //lock olduktanda sonra gerçekleşmesi istenen işlemler...
                    if(buffer.isEmpty()){
                        //reentrantLock.unlock();
                        continue;
                    }
                    System.out.println(color+"The Counter ="+counter);
                    counter=0;
                    if(buffer.get(0).equals(EOF)){
                        System.out.println(color+"Exiting");
                        //reentrantLock.unlock();
                        break;
                    }else {
                        System.out.println(color +"Thread:"+ Thread.currentThread().getName()+ "Removed..." + buffer.remove(0));
                    }
                }finally {
                    reentrantLock.unlock();
                }
            }else{
                counter++;
            }


        }
    }
}

