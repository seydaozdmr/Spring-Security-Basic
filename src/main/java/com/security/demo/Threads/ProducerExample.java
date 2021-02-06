package com.security.demo.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.security.demo.Threads.ProducerExample.EOF;
//Üretici tüketici problemi örneği:
public class ProducerExample {
    public static final String EOF="EOF";
    public static void main(String[] args) {
        List<String> buffer=new ArrayList<>();
        MyProducer myProducer=new MyProducer(buffer,ThreadColor.ANSI_BLUE);
        MyConsumer myConsumer=new MyConsumer(buffer,ThreadColor.ANSI_PURPLE);
        MyConsumer myConsumer1=new MyConsumer(buffer,ThreadColor.ANSI_RED);
        MyConsumer myConsumer2=new MyConsumer(buffer,ThreadColor.ANSI_BLACK);
        MyConsumer myConsumer3=new MyConsumer(buffer,ThreadColor.ANSI_CYAN);

        new Thread(myProducer).start();
        new Thread(myConsumer).start();
        new Thread(myConsumer1).start();
        new Thread(myConsumer2).start();
        new Thread(myConsumer3).start();
    }
}

class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random=new Random();
        List<String> nums=generateNums();
//        String [] nums={"1","2","3","4","5"};

        for(String num:nums){
            System.out.println(color+" Adding .. "+num);
            //buffer nesnesini yani arrayList'i synchronized yaptık...
            synchronized (buffer){
                buffer.add(num);
            }

            try{
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println(color+" Adding EOF and exiting....");
        synchronized (buffer) {
            buffer.add("EOF");
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

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while(true){
            synchronized (buffer){
                if(buffer.isEmpty()){
                    continue;
                }if(buffer.get(0).equals(EOF)){
                    System.out.println(color+"Exiting");
                    break;
                }else{
                    System.out.println(color+"Removed..."+buffer.remove(0));
                }
            }


        }
    }
}

