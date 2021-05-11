package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Questions7 {
    private AtomicInteger s1=new AtomicInteger(0);
    private int s2=0;
    private void countSheep() throws InterruptedException{
        ExecutorService service=null;
        try{
            service= Executors.newSingleThreadExecutor();
            for(int i=0;i<100;i++){
                service.execute(()->{
                    s1.getAndIncrement();
                    s2++;
                });
            }
            Thread.sleep(100);
            System.out.println(s1+ " "+ s2);
        }finally {
            if(service!=null) service.shutdown();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3=new ArrayList<>();
        list3.add(5);
        list3.add(6);

        List<List<Integer>> listeler=new ArrayList<>();
        listeler.add(list1);
        listeler.add(list2);
        listeler.add(list3);
        System.out.println(listeler);

        listeler.parallelStream()
                .flatMap(s->s.stream())
                .findAny()
                .ifPresent(System.out::println);

        //AtomicInteger example
        Questions7 atomicExample=new Questions7();
        atomicExample.countSheep();


    }
}
