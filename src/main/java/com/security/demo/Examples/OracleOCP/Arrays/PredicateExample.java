package com.security.demo.Examples.OracleOCP.Arrays;

import com.security.demo.Examples.OracleOCP.Condition;
import com.security.demo.Examples.OracleOCP.Product;
import com.security.demo.Examples.OracleOCP.Rating;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Product p1=new Product("tea", BigDecimal.valueOf(23.43), LocalDate.now().plusDays(2), Condition.HOT, Rating.FIVE);
        Product p2=new Product("cake",BigDecimal.valueOf(533.2),LocalDate.now().plusDays(5),Condition.COLD,Rating.FOUR);
        Product p3=new Product("coke",BigDecimal.valueOf(35.34),LocalDate.now().plusDays(343),Condition.COLD,Rating.ONE);
        Product p4=new Product("latte",BigDecimal.valueOf(23.12),LocalDate.now().plusDays(1),Condition.HOT,Rating.ONE);
        Product p5=new Product("cookie",BigDecimal.valueOf(23.12),LocalDate.now().plusDays(1),Condition.HOT,Rating.ONE);

        List<Product> liste= new ArrayList<>(); //Arrays.asList() şeklinde oluşturduğumuz liste readonly oluyor
        liste.add(p1);
        liste.add(p2);
        liste.add(p3);
        liste.add(p4);
        liste.add(p5);
        liste.removeIf(new LongProductNames());

        liste.stream().forEach(product -> System.out.println(product.getName()));

    }

    public static class LongProductNames implements Predicate<Product>{

        @Override
        public boolean test(Product product) {
            return product.getName().length()>4;
        }
    }
}
