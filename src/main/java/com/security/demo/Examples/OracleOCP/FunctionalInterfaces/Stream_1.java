package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Stream_1 {
    public static void main(String[] args) {
        Stream<String> s1=Stream.empty();
        System.out.println(s1.count());
        Stream<String> s2=Stream.of("1");
        System.out.println(s2.count());
        Stream<String> s3=Stream.of("1","2","3");
        System.out.println(s3.count());
        //infinite stream
        Stream<Double> randoms=Stream.generate(Math::random);
        //üstteki sonsuz stream'i limit ile sınırlandırabiliriz. filter ile predicate interface'ini uygulayabiliriz.
        randoms.filter(p->p<0.50).limit(100).forEach(p-> System.out.println(p));

        List<Integer> liste= new ArrayList<>();
        liste.add(1);
        liste.add(2);
        liste.add(3);

        Stream<Integer> s4=liste.stream();
        s4.forEach(System.out::println);

        //Terminal Operations
        //count() -> long
        Random r=new Random();
        Stream<Double> randoms2=Stream.generate(Math::random);
        Long sayac=randoms2.filter(p->p<0.30).limit(r.nextInt(100)).count();
        System.out.println(sayac);

        Stream<Double> randoms3=Stream.generate(Math::random);
        Optional<Double> any=randoms3.filter(p->p>0.80).findAny(); //0.80 'den büyük ilk değeri bulunca stream'i sonlandırıyor ve Optinal olarak döndürüyor.

        any.ifPresent(System.out::println);






    }
}
