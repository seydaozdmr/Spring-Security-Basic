package com.security.demo.LambdaExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise_5 {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Amelia","Olivia","emily","Isla","Ave","oliver","Jack","Peralta","Charlie","harry","rosa","Diez","Terry");

        //1.Yaklaşım
        List<String> upperCaseNames=new ArrayList<>();
        names.forEach(name -> upperCaseNames.add(name.substring(0,1).toUpperCase()+name.substring(1)));
        upperCaseNames.sort((s1,s2)-> s1.compareTo(s2)); //upperCaseNames.sort(String::compareTo)
        upperCaseNames.forEach(eleman-> System.out.println(eleman));

        //2.yaklaşım
        List<String> ikinciYaklasim=names.stream()
                .map(String::toUpperCase) //map(name-> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted()
                .collect(Collectors.toList());
        ikinciYaklasim.forEach(System.out::println);

        //3.Yaklaşım

        long startWithA=names.stream()
                .map(name -> name.substring(0,1).toUpperCase()+name.substring(1))
                .filter(name-> name.startsWith("A"))
                .count();
        System.out.println("A ile başlayan : "+startWithA);



    }
}
