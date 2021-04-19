package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors_Example {
    public static void main(String[] args) {
        Stream<String> s1=Stream.of("ali","mustafa","mahmut");
        String result=s1.collect(Collectors.joining(","));
        System.out.println(result);

        Stream<String> s2=Stream.of("ali","mustafa","mahmut");
        Double avarage=s2.collect(Collectors.averagingInt(String::length));
        System.out.println(avarage);

        //Creating map
        Stream<String> s3=Stream.of("ali","mustafa","mahmut");
        Map<String,Integer> myMap=s3.collect(Collectors.toMap(s->s,String::length));//s->s creates string key, String::length creates integer
        System.out.println(myMap);


        //reverse
        Stream<String> s4=Stream.of("ali","mustafa","mahmut","cem");
        //Map<Integer,String> myMap2=s4.collect(Collectors.toMap(String::length,s->s)); //this approach does not work
        //System.out.println(myMap2);
        Map<Integer,String> myMap2=s4.collect(Collectors.toMap(String::length,k->k,(a1,a2)->a1+","+a2));
        System.out.println(myMap2);

        //if we need specify type of map:
        Stream<String> s5=Stream.of("ali","mustafa","mahmut","cem","mehmet");
        TreeMap<Integer,String> myMap3=s5.collect(Collectors.toMap(String::length,t->t,(a1,a2)->a1+"-"+a2,TreeMap::new));
        System.out.println(myMap3);

        //grouping
        Stream<String> s6=Stream.of("ali","mustafa","mahmut","cem","mehmet");
        Map<Integer, List<String>> listeMap=s6.collect(Collectors.groupingBy(String::length));
        System.out.println(listeMap);

        //use Set insted Map
        Stream<String> s7=Stream.of("ali","mustafa","mahmut","cem","mehmet","ali");
        Map<Integer, Set<String>> listeMap2=s7.collect(Collectors.groupingBy(String::length,Collectors.toSet()));
        System.out.println(listeMap2);

        Stream<String> s8=Stream.of("ali","mustafa","mahmut","cem","mehmet","ali");
        TreeMap<Integer,List<String>> listeMap3=s8.collect(Collectors.groupingBy(String::length,TreeMap::new,Collectors.toList()));
        System.out.println(listeMap3);


        //partitioning
        Stream<String> s9=Stream.of("ali","mustafa","mahmut","cem","mehmet","ali");
        Map<Boolean,List<String>> partitioningList=s9.collect(Collectors.partitioningBy(s->s.length()<5));
        System.out.println(partitioningList);

        Stream<String> s10=Stream.of("ali","mustafa","mahmut","cem","mehmet","ali");
        Map<Boolean,Set<String>> partitioningList2=s10.collect(Collectors.partitioningBy(s->s.length()<5,Collectors.toSet()));
        System.out.println(partitioningList2);

        Stream<String> s11=Stream.of("ali","mustafa","mahmut","cem","mehmet","ali");
        Map<Integer,Long> adetListesi=s11.collect(Collectors.groupingBy(String::length,Collectors.counting()));
        System.out.println(adetListesi);

        //mapping
        Stream<String> s12=Stream.of("ali","mustafa","mahmut","cem","mehmet","ali","hüseyin");
        Map<Integer, Optional<Character>> mappingList=s12
                                                        .collect(
                                                                Collectors
                                                                        .groupingBy(String::length,
                                                                                Collectors
                                                                                        .mapping(s->s.charAt(0)
                                                                                                ,Collectors.minBy((a,b)->a-b))));
        System.out.println(mappingList);





    }

}
