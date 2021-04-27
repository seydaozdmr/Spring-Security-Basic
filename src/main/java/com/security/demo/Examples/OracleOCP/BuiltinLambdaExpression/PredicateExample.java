package com.security.demo.Examples.OracleOCP.BuiltinLambdaExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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



    }
}
