package com.security.demo.Examples.OracleOCP.Questions;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamQuestion3 {
    public static void main(String[] args) {
        Stream<String> s=Stream.generate(()->"meow");
        //s.forEach(System.out::println);

        boolean b=s.allMatch(String::isEmpty);
        System.out.println(b);

        List<String> liste=new ArrayList<>();
        liste.add("ali");
        liste.add("hasan");
        liste.add("fatma");
        liste.add("kadir");

        List<String> a1= liste.stream()
                .sorted((a,c)->c.compareTo(a))
                .collect(Collectors.toList());
        System.out.println(a1);

        IntStream a=IntStream.empty();
        System.out.println(a.sum());

        LongStream longStream=LongStream.of(1,2,3);
        OptionalLong optionalLong=longStream.map(i->i*10)
                .filter(x->x<15).findFirst();

        if(optionalLong.isPresent()) System.out.println(optionalLong.getAsLong());

        String result=Stream.iterate(1,x->++x)
                .limit(5).map(x->""+x)
                .collect(Collectors.joining());

        System.out.println(result);

        Supplier<String> bc=String::new;

        List<Integer> x1=Arrays.asList(1,2,3);
        List<Integer> x2=Arrays.asList(4,5,6);
        List<Integer> x3=Arrays.asList();

        Stream.of(x1,x2,x3).flatMap(x->x.stream()).map(x->x+1).forEach(System.out::print);

        Stream<Integer> stream=Stream.of(1);
        //IntStream iS=stream.boxed();


    }
}
