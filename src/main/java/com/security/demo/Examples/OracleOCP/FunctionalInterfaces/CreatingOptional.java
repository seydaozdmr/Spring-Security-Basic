package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.Optional;

public class CreatingOptional {
    public static void main(String[] args) {
        //Not: optional chain şeklinde kullanılabilir.
        Optional<Double> ortalama=avarage(4,5,6,7,8,9);
        if(ortalama.isPresent()){
            System.out.println(ortalama.get());
        }else{
            System.out.println("deger eksik");
        }

        Optional<Double> ortalama2=avarage2();
        System.out.println(ortalama2.get());

        //tek satırda ifPresent ve Consumer(tüketici - yaptırıcı örn:System.out::println) interface'i (lambda) kullanarak değeri yazdırabiliriz.
        ortalama.ifPresent(System.out::println);

        //dönen değerin olmaması ihtimaline karşı hemen farklı bir seçenek yaratabiliyoruz.
        System.out.println(ortalama2.orElse(Double.NaN));

        Optional<Double> ortalama3=avarage();
        System.out.println(ortalama3.orElseGet(()-> Math.random()));
        System.out.println(ortalama3.orElseThrow(()->new IllegalArgumentException()));
    }

    public static  Optional<Double> avarage(int ...scores){
        if(scores==null) return Optional.empty();
        int sum=0;
        for(int i:scores) sum+=i;
        return Optional.of((double) sum/ scores.length);

    }
    public static Optional<Double> avarage2(int ...scores){
        int sum=0;
        for(int i:scores) sum+=i;
        return Optional.ofNullable((double)sum/scores.length); //ya null ya value
    }
}
