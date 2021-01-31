package com.security.demo.Threads;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CountDown_4 implements ApplicationListener<ContextRefreshedEvent>{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        CountDown countDown=new CountDown();
        //Eğer ayrı ayrı nesneler oluşturursak bunları kullanan Threadler ayrı ayrı çalışır.
        //CountDown countDown2=new CountDown();

        CountdownThread t1=new CountdownThread(countDown);
        t1.setName("Thread 1");
        CountdownThread t2=new CountdownThread(countDown);
        t2.setName("Thread 2");

        //Thread interference
        Counter counter=new Counter();
        CounterThread th1=new CounterThread(counter);
        th1.start();
        Arttir th2=new Arttir(counter);
        th2.start();



        //Thread'i extend edttiği için start ile çalıştırıyoruz.
        t1.start();
        t2.start();
    }

    class Counter {
        private int c=0;
        public void increment(){
            c++;
        }
        private void decrement(){
            c--;
        }
        public int value(){
            return c;
        }
    }

    class CounterThread extends Thread{
        private Counter counter;

        public CounterThread (Counter counter){
            this.counter=counter;
        }
        public void run(){
            for(int i=0;i<10;i++){
                counter.decrement();
                System.out.println(counter.value());
            }
        }
    }
    class Arttir extends Thread{
        private Counter counter;
        public Arttir(Counter counter){
            this.counter=counter;
        }
        public void run(){
            for(int i=0;i<10;i++){
                counter.increment();
                System.out.println(counter.value());
            }
        }
    }


    class CountDown{
        //Daha önce local variable kullanıştık for loop içinde
        //Bu durumda jvm local variable için stack de yer ayırıyor.
        //Aksi durumda burada instance variable kullanıyoruz. Bu durumda iki Thread'de aynı insantance paylaşacaklar.
        //Bu durumda heap 'de yer ayrılıyor ve aynı nesne örneğini kullandıkları için aynı instance değişkeni kullanıyorlar.
        private int i;
        //Bu metodu çalıştıran Thread'lerin ayrı ayrı karışmadan çalışmasını (interference) istiyorsak synchronized kullanmamız gerekiyor.
        public void doCountDown(){
            String color;
            switch (Thread.currentThread().getName()){
                case "Thread 1":
                    color=ThreadColor.ANSI_BLUE;
                    break;
                case "Thread 2":
                    color=ThreadColor.ANSI_PURPLE;
                    break;
                default:
                    color=ThreadColor.ANSI_GREEN;
            }
            synchronized (this){
                for(i=10;i>0;i--){
                    System.out.println(color+ Thread.currentThread().getName()+" : i = "+i);
                }

            }


        }
    }

    class CountdownThread extends Thread{
        private CountDown threadCountdown;

        public CountdownThread(CountDown countDown){
            threadCountdown=countDown;
        }

        public void run(){
            //Thread'i yaratılan nesne tarafından start edilince threadCountdown'ın doCountDown() metodunu çalıştırmış oluyoruz.
            threadCountdown.doCountDown();
        }
    }
}
