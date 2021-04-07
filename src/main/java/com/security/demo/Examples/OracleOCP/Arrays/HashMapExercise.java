package com.security.demo.Examples.OracleOCP.Arrays;

import com.security.demo.Examples.OracleOCP.Condition;
import com.security.demo.Examples.OracleOCP.Product;
import com.security.demo.Examples.OracleOCP.Rating;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HashMapExercise {
    public static void main(String[] args) {
        Product p1=new Product("tea", BigDecimal.valueOf(23.43), LocalDate.now().plusDays(2), Condition.HOT, Rating.FIVE);
        Product p2=new Product("cake",BigDecimal.valueOf(533.2),LocalDate.now().plusDays(5),Condition.COLD,Rating.FOUR);
        Product p3=new Product("coke",BigDecimal.valueOf(35.34),LocalDate.now().plusDays(343),Condition.COLD,Rating.ONE);
        Product p4=new Product("latte",BigDecimal.valueOf(23.12),LocalDate.now().plusDays(1),Condition.HOT,Rating.ONE);
        Product p5=new Product("cookie",BigDecimal.valueOf(23.12),LocalDate.now().plusDays(1),Condition.HOT,Rating.ONE);

        Map<Integer,Product>  liste=new HashMap<>();

        liste.put(1,p1);
        liste.put(2,p2);
        liste.put(3,p3);
        liste.put(4,p4);

        liste.put(3,p5);
        System.out.println(liste.get(3).getName());

    }
}
