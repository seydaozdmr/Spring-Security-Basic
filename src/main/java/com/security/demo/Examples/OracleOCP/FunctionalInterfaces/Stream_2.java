package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream_2 {
    public static void main(String[] args) {
        List<String> data=new ArrayList<>();
        data.add("mike");
        data.add("hank");
        data.add("walter");
        Stream<String> stream=data.stream();
        data.add("gustavo");
        //lazily evaluated - stream kaynağı biliyor fakat içeriğe çağrıldığı zaman ulaşıyor.
        stream.forEach(System.out::println);

    }
}
