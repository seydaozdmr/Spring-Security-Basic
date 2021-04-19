package com.security.demo.Examples.OracleOCP.Questions;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamQuestion2 {
    public static void main(String[] args) {
        double result= LongStream.of(6L,8L,10L)
                .mapToInt(x->(int)x)
                .boxed()
                .collect(Collectors.groupingBy(k->k))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x->x));
        System.out.println(result);

        double result2=LongStream.of(6L,8L,10L)
                .mapToInt(x->(int)x)
                .boxed()
                .collect(Collectors.averagingInt(x->x));

        System.out.println(result2);
        //yukardaki örnekte ilk collect ile Stream<Integer> map 'e dönüştürülmüş daha sonra map'teki
        //key'ler keySet ile alınıp yeniden bir stream oluşturulmış ve son collect ile ortalama int değeri
        //double geri dönecek şekilde collect ile gerçekleştirilmiştir.

        double result3=LongStream.of(6L,8L,10L)
                .mapToInt(x->(int)x)
                .boxed()
                .collect(Collectors.groupingBy(y->y,Collectors.toSet()))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x->x));
        System.out.println(result);

        double result4=LongStream.of(6L,8L,10L)
                .mapToInt(x->(int)x)
                .boxed()
                .collect(Collectors.groupingBy(y->y,Collectors.toSet()))
                .values()
                .stream()
                .count();
        double result5=LongStream.of(6L,8L,10L)
                .mapToInt(x->(int)x)
                .boxed()
                .collect(Collectors.groupingBy(y->y,Collectors.toSet()))
                .keySet()
                .stream()
                .collect(Collectors.averagingInt(x->x));
        System.out.println(result);

       // System.out.println(result4);

    }
}
