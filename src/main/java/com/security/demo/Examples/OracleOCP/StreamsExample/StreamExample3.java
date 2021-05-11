package com.security.demo.Examples.OracleOCP.StreamsExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamExample3 {
    public static void main(String[] args) {
        List<Integer> listem=new ArrayList<>();
        listem.add(1);
        listem.add(5);
        listem.add(3);
        listem.add(2);
        listem.add(4);

        IntStream stream=listem.stream().flatMapToInt(p-> IntStream.of(p));

        int elem= stream.sum();
        System.out.println(elem);
    }
}
