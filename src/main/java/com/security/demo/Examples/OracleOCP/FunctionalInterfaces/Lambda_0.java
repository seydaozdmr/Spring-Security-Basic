package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Lambda_0 {
    public static void main(String[] args) {
        Supplier<String> get=()->new String("Seyda");
        System.out.println(get.get());
        Stream<String> s1=Stream.generate(get);
        s1.limit(10).forEach(System.out::println);

        Consumer<String> c1= p-> {
            p=p.toUpperCase();
            System.out.println(p);
        };
        c1.accept("name");




    }
}
