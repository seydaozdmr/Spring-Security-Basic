package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Example_5 {
    public static void main(String[] args) {
        UnaryOperator<String> func=p->p.toUpperCase();

        System.out.println(func.apply("ankara"));

        Predicate<Integer> dogrula=Dogrula::yasKontrol;
        System.out.println(dogrula.test(19));

        Dogrula d1=new Dogrula() {
            @Override
            public void hello(String mesaj) {
                System.out.println(mesaj);
            }
        };

        Consumer<String> c1=d1::hello;
    }
}

interface Dogrula{
    static boolean yasKontrol(int yas){
        return yas>18;
    }
    void hello(String mesaj);
}
