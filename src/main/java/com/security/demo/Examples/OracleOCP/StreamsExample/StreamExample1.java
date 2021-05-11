package com.security.demo.Examples.OracleOCP.StreamsExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Integer> listem=new ArrayList<>();
        listem.add(1);
        listem.add(2);
        listem.add(3);
        listem.add(4);
        listem.add(5);
        listem.forEach(System.out::println);
        System.out.println("**************************");
        listem.forEach(elem->{
            System.out.println(elem);
        });
        System.out.println("****************************");
        listem.stream().limit(3).filter(p->p>2).forEach(System.out::println);
        System.out.println("******************************");
        Stream<Integer> s1=Stream.of(1,2,3,4,5);
        //s1.forEach(System.out::println);
        s1.map(p->p*2).forEach(System.out::println);

        Set<String> mySet=new HashSet<>();
        mySet.add("a");
        mySet.add("b");
        mySet.add("c");

        Set<String> result=mySet.stream().map(elem->elem+elem).collect(Collectors.toSet());
        System.out.println(result);

        result.stream()
                .filter(elem->elem.startsWith("a"))
                .forEach(System.out::println);
        System.out.println("********************************");

    }
}
