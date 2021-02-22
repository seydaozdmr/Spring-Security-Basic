package com.security.demo.LambdaExamples;

import java.util.function.Supplier;

public class Exercise_4 {
    public static void main(String[] args) {
        Supplier<String> iLoveJava= () -> {return "i Love Java!"; };
        System.out.println(new String(iLoveJava.get()));
    }
}
