package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Questions1 {
    private static int count;
    public static void countIceCreamFlavors (){
        count=0;
        Runnable task=()->count++;
        LongStream.range(1,500)
                .forEach(m->new Thread(task).run()); //run() kullandığımız için threadleri synchronously şekilde çalıştırır.
        System.out.println(count);
    }

    public static void main(String[] args) {
        //value atomic olduğu için sonuç tutarlı oluyor
        //atomiclong vs long array
        AtomicLong value=new AtomicLong(0);
        final long[] value2={0};
        IntStream.iterate(1,i->1).limit(100).parallel()
                .forEach(i->value.incrementAndGet());
        IntStream.iterate(1,i->1).limit(100).parallel()
                .forEach(i->++value2[0]);
        System.out.println(value+" "+value2[0]);


        //parallel maptoint and forEachOrdered
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.stream()
                .parallel()
                .mapToInt(s->s)
                .peek(System.out::println)
                .forEachOrdered(System.out::println);  //listedeki elemanların sırasında listeler

        //Livelook occurs when two or more threads are conceptually blocked forever,
        //although they are each still active and trying to complete their task.
        //A race condition is an undesirable result that occurs when two tasks are completed
        //at the same time, which should have been sequentially;

        //Single Thread example
        countIceCreamFlavors();



    }

}
