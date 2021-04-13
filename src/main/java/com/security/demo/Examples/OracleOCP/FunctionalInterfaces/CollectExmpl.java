package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExmpl {
    public static void main(String[] args) {
        //<R> collect (Supplier<R> supplier, BiConsumer<R,? super T>, BiConsumer<R,R> combiner)
        //<R,A> R collect (Collector<? super T,A,R> collect)

        Stream<String> stream=Stream.of("a","b","c","d","e","f");
        StringBuilder sb=stream.collect(StringBuilder::new,StringBuilder::append,StringBuilder::append);
        System.out.println(sb);

        //ortak collectorlar için java'da Collectors sınıfı bulunuyor

        Stream<String> s2=Stream.of("b","a","c","b","d","d","a","b","g");
        TreeSet<String> ts=s2.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(ts);

        Stream<Integer> s3=Stream.of(1,2,3,4,5,6,7,8,9);
        Set<Integer> s4=s3.collect(Collectors.toSet());
        System.out.println(s4);

    }
}
