package com.security.demo.Examples.OracleOCP.StreamsExample;

import com.security.demo.Examples.OracleOCP.Exercise_1.AbstractProduct;
import com.security.demo.Examples.OracleOCP.Exercise_1.Drink;
import com.security.demo.Examples.OracleOCP.Exercise_1.Food;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterExample {
    public static void main(String[] args) {
        List<Integer> sayiListesi=new ArrayList<>();
        for(int i=0;i<1000000;i++){
            sayiListesi.add(i);
        }

        LocalTime time=LocalTime.now();
        //sayiListesi.stream().parallel().filter(p-> p%2==0).forEach(System.out::println);
        LocalTime time2=LocalTime.now();

        System.out.println(time.getSecond()-time2.getSecond());

        System.out.println("*************************************************");
        time=LocalTime.now();
//        for(Integer i:sayiListesi){
//            if(i%2==0){
//                System.out.println(i);
//            }
//        }
        time2=LocalTime.now();
        System.out.println("*****************************************************");
        System.out.println(time.getSecond()-time2.getSecond());

        Stream.of(new Food(),new Drink()).forEach(p->p.setPrice(BigDecimal.ONE));

        //sayı listesini string listesine dönüştürdük
        List<String> sum=sayiListesi.stream().parallel().peek(p->p+=1).map(p->p.toString()).collect(Collectors.toList());
        //sum.forEach(System.out::println);
        Stream.of("ONE","TWO","THREE","FOUR").mapToInt(p->p.length()).peek(i-> System.out.println(i)).filter(i->i>3);



    }
}
