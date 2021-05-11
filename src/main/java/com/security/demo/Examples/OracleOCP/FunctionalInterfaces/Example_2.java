package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.LongToDoubleFunction;
import java.util.stream.Collectors;

public class Example_2 {
    public static void main(String[] args) {
        //Function<T,T> builtin function
        Topla topla=(a,b)->a+b;
        System.out.println(topla.toplam(10,19));

        Function<Integer,Integer> s1=elem->100;
        System.out.println(s1.apply(200));

        List<String> listem=new ArrayList<>();
        listem.add("ankara");
        listem.add("burdur");
        listem.add("antalya");

        System.out.println(listem.stream().map(p->p.length()).collect(Collectors.toList()));

        String [] languages={"Java","Kotlin","Python","Javascript"};
        Function<String [],Integer> langs=item->{
            int toplam=0;
            for(String i:item){
                toplam+=i.length();
            }
            return toplam;
        };

        System.out.println(langs.apply(languages));


        Function<Integer,Integer> toplama=item->{
            return item+10;
        };
        Function<Integer,Integer> carpma=item->{
            return item*3;
        };
        Function<Integer,Integer> res= toplama.andThen(carpma);
        System.out.println(res.apply(5));

        LongToDoubleFunction function=elem-> (double) elem;
        System.out.println(function.applyAsDouble(555));
    }


}
interface Topla{
    int toplam(int a,int b);
}
