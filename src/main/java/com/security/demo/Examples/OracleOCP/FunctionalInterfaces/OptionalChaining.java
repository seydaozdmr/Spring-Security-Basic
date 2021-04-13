package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class OptionalChaining {
    public static void main(String[] args) {

        Stream<Integer> s=Stream.of(100);

        threeDigit(s.findFirst());


    }

    public static void threeDigit(Optional<Integer> optional){
        if(optional.isPresent()){
            int digit=optional.get();
            String s=""+digit;
            if(s.length()==3) System.out.println(s);
        }
    }

    private static void threeDigitLambda(Optional<Integer> optional){
        optional.map(n->""+n)
                .filter(p->p.length()==3)
                .ifPresent(System.out::println);

    }
}
