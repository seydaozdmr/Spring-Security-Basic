package com.security.demo.Threads;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import static com.security.demo.Threads.ThreadColor.*;


public class MainThreads_1 implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        System.out.println("Reading array for 4 second delay:");
//        Thread newThread=new Sleep_5();
//        newThread.start();
//
//        System.out.println(ANSI_PURPLE+ "hello world");
//        Thread anotherThread=new AnotherThread_2();
//        anotherThread.setName("***ANOTHER THREAD***");
//        anotherThread.start();
//        System.out.println(ANSI_GREEN+"hello again the main thread...");
//
//        //anotherThread.start(); you can use the same thread second time
//
//        //anonymous class thread::
//        new Thread(){
//            public void run(){
//                System.out.println(ANSI_CYAN+"hello from anonymous class thread");
//            }
//        }.start();
//        //Runnable implemente edilmiş bir sınıfı kendi sınıfımızda Thread olarak çalıştırabiliriz.
////        Thread myRunnable=new Thread(new MyRunnable_3());
////        myRunnable.start();
//
//        //Aynı sınıfın run metodunu Override edebiliriz
//        Thread myRunnable=new Thread(new MyRunnable_3() {
//            @Override
//            public void run() {
//                System.out.println(ANSI_RED +"Hello from the anonymous Class's implementation");
//                try {
//                    //myRunnable threadi içerisinde anotherThread Thread'ini çağırdık ve çalıştırdık.
//                    //Burada önceliği anotherThread'e veriyoruz ve onun bitmesini bekliyoruz
//                    anotherThread.join();
//
//                }catch (InterruptedException e){
//                    System.out.println(ANSI_RED+"I couldn't wait after all. I was interrupted.");
//                }
//                System.out.println(ANSI_GREEN+"This is the contunie of preceeding anotherThread Thread.");
//            }
//        });
//
//        myRunnable.start();
//        //anotherThread.interrupt();
//
//        System.out.println(ANSI_RESET+"hello again the main thread yet another again");
   }
}
