package com.security.demo.Examples.OracleOCP;

import org.springframework.security.core.parameters.P;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    public static void main(String[] args) {
        Product product=new Product("tea",BigDecimal.valueOf(3.44), LocalDate.now(),Condition.HOT,Rating.FOUR);
        Product product2=new Product("coke",BigDecimal.valueOf(6.44), LocalDate.now(),Condition.COLD,Rating.ONE);
        Product product3=new Product("cake",BigDecimal.valueOf(8.44), LocalDate.now(),Condition.WARM,Rating.FIVE);

        List<Product> liste=new ArrayList<>();
        liste.add(product);
        liste.add(product2);
        liste.add(product3);

        Collections.sort(liste);

        liste.forEach(p -> System.out.println(p.getName()));
        //product.setDefaultExpiryPeriod(4);
        //product.setName("Tea");
        // product.setPrice(BigDecimal.valueOf(1.99));
        System.out.println(product.getDefaultExpiryPeriod());
        //defaultExpiryPeriod static variable is setted by public static final MAX_EXPIRY_PERIOD value;
        //Product.setDefaultExpiryPeriod(Product.MAX_EXPIRY_PERIOD);
        System.out.println("indirimli fiyat :"+product.getDiscount());

        Product p4=new Product();
        System.out.println("indirimli fiyat 2 :"+p4.getDiscount());

        //we can access only Object's methods on heap none of Product's
        Object o1=new Product();
        System.out.println(o1.toString());





    }


}
