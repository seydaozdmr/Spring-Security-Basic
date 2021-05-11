package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Questions2 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> lions=new ArrayList<>();
        lions.add(1);
        lions.add(2);
        lions.add(3);

        List<Integer> tigers=new CopyOnWriteArrayList<>(lions); //note: CopyOnWriteArrayList iterate original list
        Set<Integer> bears=new ConcurrentSkipListSet<>(); //doesn't allow dublicate
        bears.addAll(tigers);

        for(Integer item:tigers) tigers.add(4);
        for(Integer item:bears) bears.add(5);
        System.out.println(lions.size()+" "+tigers.size()+" "+bears.size());

        //awaitTermination
        ExecutorService service=null;
        try{
            service= Executors.newFixedThreadPool(4);
            service.execute(()->takeNap());
            //service.execute(()->takeNap());
            //service.execute(()->takeNap());
        }finally {
            if(service!=null) service.shutdown();
        }

        service.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("DONE!!!");



    }

    public static void takeNap(){
        try{
            for(int i=1;i<6;i++){
                Long start=System.currentTimeMillis();
                Thread.sleep(1000);
                System.out.println((System.currentTimeMillis()-start)/1000*i);
            }
            //Thread.sleep(5000);


        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
