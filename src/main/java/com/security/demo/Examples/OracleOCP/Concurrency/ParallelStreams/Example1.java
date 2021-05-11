package com.security.demo.Examples.OracleOCP.Concurrency.ParallelStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {
        Stream<Integer> s1=Stream.of(1,2,3,4,5,6);
        s1.parallel().forEach(p-> System.out.println(Thread.currentThread().getName()+" : "+p));

        //Serial stream example
//        Long start=System.currentTimeMillis();
//        List<Integer> liste=new ArrayList<>();
//        liste.add(1);
//        liste.add(2);
//        liste.add(3);
//        liste.add(4);
//        liste.add(5);
//        liste.stream().map(p->doWork(p)).forEach(elem-> System.out.println(elem+" "));
//        System.out.println();
//        Long result=(System.currentTimeMillis()-start)/1000;
//        System.out.println("Time : "+result+ " seconds");

        //parallel stream example:
        Long start=System.currentTimeMillis();
        List<Integer> liste=new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(3);
        liste.add(4);
        liste.add(5);
        liste.stream().parallel().map(p->doWork(p))
                .forEach(elem-> System.out.println(Thread.currentThread().getName()+" - "+elem+" "));
        System.out.println();
        Long result=(System.currentTimeMillis()-start)/1000;
        System.out.println("Time : "+result+ " seconds");

    }
    public static int doWork(int time){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return time;
    }
}
