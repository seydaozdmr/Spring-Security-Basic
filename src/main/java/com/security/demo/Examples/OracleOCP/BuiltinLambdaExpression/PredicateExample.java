package com.security.demo.Examples.OracleOCP.BuiltinLambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> strings=new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");

        strings.removeIf(s->s.startsWith("t"));
        System.out.println(strings);

        Consumer<String> action=s-> System.out.println(s);
        strings.forEach(action);

        DoubleToIntFunction function=v->(int) v;
        int pi=function.applyAsInt(Math.PI);
        System.out.println(pi);

        List<String> s=new ArrayList<>();
        s.add("one");
        s.add("two");
        s.add("three");
        s.add("four");
        s.add("five");
        s.add("six");
        Comparator<String> str=(s1,s2)->s1.compareTo(s2);
        Collections.sort(s,str);
        System.out.println(s);



    }
}
