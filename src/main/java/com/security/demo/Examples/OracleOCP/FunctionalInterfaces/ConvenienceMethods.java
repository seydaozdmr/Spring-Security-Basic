package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConvenienceMethods {
    public static void main(String[] args) {
        Predicate<String> p1=s->s.contains("egg");
        Predicate<String> p2=s->s.length()>10;

        Predicate<String> p1p2=p1.and(p2);
        System.out.println(p1p2.test("egggg"));

        Consumer<String> c1=x-> System.out.println("1 : "+x);
        Consumer<String> c2= x-> System.out.println("2 : "+x);

        //fonksiyonları zincir şeklinde hemen uygulayabiliriz ya da Başla bir consumer'a da atayabiliriz.
        c1.andThen(c2).accept("seyda");

        Function<Integer,Integer> f1=x-> x*2;
        Function<Integer,Integer> f2=x-> x*5;

        Function<Integer, Integer> f3=f1.compose(f2);
        System.out.println(f3.apply(10));
    }
}
