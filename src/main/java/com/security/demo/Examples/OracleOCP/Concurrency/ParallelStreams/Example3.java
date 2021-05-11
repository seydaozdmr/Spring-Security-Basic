package com.security.demo.Examples.OracleOCP.Concurrency.ParallelStreams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example3 {
    public static void main(String[] args) {
        //Combining results with collect():
        Stream<String> s1=Stream.of("w","o","l","f").parallel();
        SortedSet<String> set= s1.collect(ConcurrentSkipListSet::new, Set::add,Set::addAll);
        System.out.println(set);//result naturel ordering of elements

        Stream<String> s2=Stream.of("lions","tigers","bears").parallel();
        ConcurrentMap<Integer,String> myMap=s2.collect(Collectors.toConcurrentMap(String::length,k->k,(s3,s4)->s3+","+s4));
        System.out.println(myMap);

        Stream<String> s3=Stream.of("lions","tigers","bears").parallel();
        ConcurrentMap<Integer, List<String>> map=s3.collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map);

    }
}
