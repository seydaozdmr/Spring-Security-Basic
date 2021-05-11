package com.security.demo.Examples.OracleOCP.Concurrency.ParallelStreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example4 {
    //statefull operations

    public static void main(String[] args) {
        List<Integer> listem=addValues(IntStream.range(1,11));
        System.out.println(listem);

        List<Integer> listemParallel=addValues(IntStream.range(1,11).parallel());
        System.out.println(listemParallel);

        List<Integer> listemNotStatefull=addValuesNotStatefull(IntStream.range(1,11).parallel());
        System.out.println(listemNotStatefull);
    }

    public static List<Integer> addValues(IntStream source){
        List<Integer> data= Collections.synchronizedList(new ArrayList<>());
        source.filter(s->s%2==0).forEach(i-> {
            data.add(i);
        });
        return data;
    }

    //not statefull
    public static List<Integer> addValuesNotStatefull(IntStream source){
        return source.filter(s->s%2==0).boxed().collect(Collectors.toList());
    }

}
