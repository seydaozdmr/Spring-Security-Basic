package com.security.demo.LambdaExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example_15 {
    public static void main(String[] args) {
        List<String> bingoNumbers= Arrays.asList("N40","N36","B12","B6","G53","G49","G60","G50","g64");

        List<String> gNumbers=new ArrayList<>();
//        bingoNumbers.forEach(number->{
//            if(number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((s1,s2)->s1.compareTo(s2));
//        gNumbers.forEach(n-> System.out.println(n));

        //Yukarıdaki bütün işlemi stream() ile yapacağız:
        bingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        bingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(s->gNumbers.add(s));
        System.out.println("G numbers: ");
        gNumbers.forEach(System.out::println);

        //Bir listede toplamak için:
        List<String> gNumbersList=bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s-> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println("--GNUMBERS LİST--");
        gNumbersList.forEach(s -> System.out.println(s));
        //Not: collect metodu 3 adet argüman alıyor bunlar, supplier(kaynak), accumulator , combiner
        //Örneğim belirli yaştaki personeli listelemek için collect içerisinde grouppingBy kullanabiliriz.




    }
}
