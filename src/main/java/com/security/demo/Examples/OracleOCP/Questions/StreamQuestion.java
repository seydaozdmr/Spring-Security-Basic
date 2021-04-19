package com.security.demo.Examples.OracleOCP.Questions;

import java.util.List;
import java.util.Map;
import java.util.function.LongToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamQuestion {
    public static void main(String[] args) {
        double result= LongStream.of(6L,8L,10L)
                .mapToInt(x->(int)x)
                .boxed()
                .collect(Collectors.groupingBy(x->x))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x->x));

        System.out.println(result);

        LongStream.of(6L,8L,10L,8L)
                .mapToInt(x->(int)x)
                .boxed() //primitive stream'i Stream<Integer> tipindeki stream'e dönüştürüyor.
                .collect(Collectors.groupingBy(x->x))
                .forEach((k,v)-> System.out.println("k: "+k+" v: "+v));

        LongStream.of(6L,8L,10L,8L)
                .mapToInt(x->(int)x)
                .forEach(System.out::println);

        LongToIntFunction lngtoInt=new LongToIntFunction() {
            @Override
            public int applyAsInt(long value) {
                return (int)value;
            }
        };

        LongStream.of(6L,8L,10L,12L)
                .mapToInt(lngtoInt) //yukarıda tanımladığımız longToInt fonksiyonunu çağırıyoruz.
                .forEach(System.out::println);

        LongStream.of(6L,8L,10L,12L)
                .map(x->x*2)//buradaki map unary function olarak çalışıyor Long olarak map ediyor
                .boxed()//stream'i long tipine dönüştürüyor Stream<Long>
                .collect(Collectors.groupingBy(a->a))//Map<Long,List<Long>> türünde map üretiyor
                .keySet() //üretilen map'in yalnızca keySet'ini alıyoruz
                .forEach(System.out::println); //yazdırıyoruz.


        Stream<Long> longStream=Stream.of(2L,3L,5L,6L);
        longStream.mapToLong(x->x) //burada primitive yaptım stream'i
                .mapToInt(k->(int)k)//longToInt function
                .mapToObj(x->x) //boxed()
                .collect(Collectors.groupingBy(l->l))
                .keySet()
                .forEach(System.out::println);




    }
}
