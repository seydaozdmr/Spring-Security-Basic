package com.security.demo.Examples.OracleOCP.Concurrency.Questions;



import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions5 {
    public static void main(String[] args) throws InterruptedException {
        Stream<String> s1=Stream.of("leopard","lynx","ocelot","puma").parallel();
        Stream<String> s2=Stream.of("panda","grizzly","polar").parallel();

        ConcurrentMap<Boolean,List<String>> listem=Stream.of(s1,s2).flatMap(s->s)
                .collect(Collectors.groupingByConcurrent(s->!s.startsWith("p")));
        //oluşturulan map içerisinde true ve false değerlerine karşılık bir liste bulunuyor
        //true değerleri p ile başlamayanlar
        //false değerleri p ile başlayanlar
        System.out.println(listem.get(false).size());
        System.out.println(listem.get(true).size());

        for(Map.Entry elem: listem.entrySet()){
            System.out.println(elem+ " " +listem.get(elem));
        }

        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
        addAndPrintItems(queue);
    }

    public static void addAndPrintItems(BlockingQueue<Integer> queue) throws InterruptedException {
        queue.offer(103);
        queue.offer(20,1, TimeUnit.SECONDS);
        queue.offer(85,1,TimeUnit.HOURS);

        System.out.println(queue.poll(200,TimeUnit.NANOSECONDS));
        System.out.println(""+queue.poll(1,TimeUnit.MINUTES));
    }
}
