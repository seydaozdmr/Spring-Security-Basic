package com.security.demo.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static com.security.demo.Threads.ProducerExample.EOF;

public class ProducerExampleQueue {
    public static final String EOF="EOF";
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer=new ArrayBlockingQueue<String>(40);
        //ReentrantLock bufferLock=new ReentrantLock(); BufferLock'a gerek yok artık
        ExecutorService executorService= Executors.newFixedThreadPool(7);
        MyProducer3 myProducer=new MyProducer3(buffer,ThreadColor.ANSI_BLUE);
        MyConsumer3 myConsumer=new MyConsumer3(buffer,ThreadColor.ANSI_PURPLE);
        MyConsumer3 myConsumer1=new MyConsumer3(buffer,ThreadColor.ANSI_RED);
        MyConsumer3 myConsumer2=new MyConsumer3(buffer,ThreadColor.ANSI_BLACK);
        MyConsumer3 myConsumer3=new MyConsumer3(buffer,ThreadColor.ANSI_CYAN);
        Uretici uretici=new Uretici(buffer,ThreadColor.ANSI_GREEN);
        Uretici uretici2=new Uretici(buffer,ThreadColor.ANSI_BLUE);
        Uretici uretici3=new Uretici(buffer,ThreadColor.ANSI_GREEN);
        Uretici uretici4=new Uretici(buffer,ThreadColor.ANSI_BLUE);
        executorService.execute(myProducer);
        executorService.execute(myConsumer);
        executorService.execute(myConsumer1);
        executorService.execute(myConsumer2);
        executorService.execute(myConsumer3);
        executorService.execute(uretici);
        executorService.execute(uretici2);
        executorService.execute(uretici3);
        executorService.execute(uretici4);
        //eğer işlem bittikten sonra executorService'i kapatmazsak thread pool çalışmaya devam eder
        executorService.shutdown();
//        new Thread(myProducer).start();
//        new Thread(myConsumer).start();
//        new Thread(myConsumer1).start();
//        new Thread(myConsumer2).start();
//        new Thread(myConsumer3).start();
    }
}

class MyProducer3 implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;
    //private ReentrantLock reentrantLock;

    public MyProducer3(ArrayBlockingQueue<String> buffer, String color ) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random=new Random();
        List<String> nums=generateNums();
//        String [] nums={"1","2","3","4","5"};

        for(String num:nums){
            try{
                System.out.println(color+"Thread:"+Thread.currentThread().getName()+" Adding .. "+num);
                buffer.put(num);
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(color+" Adding EOF and exiting....");
        try{
            buffer.put("EOF");
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    private List<String> generateNums() {
        Random random=new Random();
        List<String> nums=new ArrayList<>();
        for(int i=0;i<20;i++){
            nums.add(String.valueOf(random.nextInt(10000)));
        }
        return nums;
    }
}

class Uretici implements Runnable{
    private ArrayBlockingQueue<String> uretici;
    private String color;

    public Uretici(ArrayBlockingQueue<String> uretici, String color) {
        this.uretici = uretici;
        this.color = color;
    }

    @Override
    public void run() {
        Random random=new Random();
        for(int i=0;i<20;i++){
            try{
                String num=String.valueOf(random.nextInt(10000));
                uretici.put(num);
                System.out.println(color+"Thread:"+Thread.currentThread().getName()+" Üretici bu sayıyı üretti .. "+num);
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(color+" Adding EOF and exiting....");
        try{
            uretici.put("EOF");
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}

class MyConsumer3 implements Runnable{
    private ArrayBlockingQueue<String> buffer;
    private String color;


    public MyConsumer3(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        //thread kod bloğunu işleme alana kadar geçen süreyi hesaplamak için

        while(true){
            //eğer lock durumundaysa if bloğu çalışacak ve unlock gerçekleşecek

            synchronized (buffer){
                try{
                    //lock olduktanda sonra gerçekleşmesi istenen işlemler...
                    if(buffer.isEmpty()){
                        //reentrantLock.unlock();
                        continue;
                    }
                    if(buffer.peek().equals(EOF)){
                        System.out.println(color+"Exiting");
                        //reentrantLock.unlock();
                        break;
                    }else {
                        System.out.println(color +"Thread:"+ Thread.currentThread().getName()+ "Removed..." + buffer.take());
                    }
                }catch (InterruptedException e){
                    System.out.println(e.getMessage()) ;
                }
            }
        }
    }
}

