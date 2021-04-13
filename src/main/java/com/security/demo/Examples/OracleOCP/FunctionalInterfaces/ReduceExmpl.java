package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceExmpl {
    public static void main(String[] args) {
        //Reduce metodu bir streamdeki elemanları tek bir obje haline getiren süreçtir. (İndirgeme)
        //T reduce ( T identity, BinaryOperator<T> accumulator)
        //Optional<T> reduce(BinaryOperator<T> accumulator)
        //<U> U reduce (U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        //3 farklı metot signature kullabilir.

        String [] dizi={"h","e","l","l","o"};
        String sonuc="";
        for(String i:dizi) sonuc+=i;
        System.out.println(sonuc);

        sonuc="";
        Stream<String> stream=Stream.of(dizi);
        sonuc=stream.reduce("",(k,v)->k+v+" "); //BinaryOperator kullanıldı.
        System.out.println(sonuc);

        // sonuc=stream.reduce("",String::concat); şeklinde yazabiliriz.

        Stream<Integer> yStream=Stream.of(1,2,3,4,5,6);
        Integer s1=yStream.reduce(1,(a,b)->a*b);
        System.out.println(s1);


        //Optional<T> method signature
        BinaryOperator<Integer> toplam=(a,b)->a+b;
        Stream<Integer> s2=Stream.empty();
        Stream<Integer> s3=Stream.of(3);
        Stream<Integer> s4=Stream.of(1,2,3,4,5);

        s2.reduce(toplam).ifPresent(System.out::println);
        s3.reduce(toplam).ifPresent(System.out::println);
        s4.reduce(toplam).ifPresent(System.out::println);

        //<U> U reduce (U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        //farklı tiplerde indirgeme yaparken bu metotu kullanabiliriz

        Stream<Integer> s5=Stream.of(1,2,3,4,5,6,7,8,9,10);
        String snc=s5.reduce("",(a,b)->a.toString()+b.toString()+"-",(x,y)->x+y);
        System.out.println(snc);

    }
}
