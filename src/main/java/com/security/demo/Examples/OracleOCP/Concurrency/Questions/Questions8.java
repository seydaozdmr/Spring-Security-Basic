package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class Questions8 {
    public static void await(CyclicBarrier cb){
        try{
            cb.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(10,()-> System.out.println("Stock room full"));

        IntStream.iterate(1,i->1).limit(10).parallel().forEach(i->await(cyclicBarrier));
    }
}
