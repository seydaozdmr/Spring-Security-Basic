package com.security.demo.Examples.OracleOCP.Arrays;

import com.security.demo.Examples.OracleOCP.Condition;
import com.security.demo.Examples.OracleOCP.Product;
import com.security.demo.Examples.OracleOCP.Rating;
import org.springframework.security.core.parameters.P;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExercise {
    public static void main(String[] args) {
        Product p1=new Product("tea", BigDecimal.valueOf(23.43), LocalDate.now().plusDays(2), Condition.HOT, Rating.FIVE);
        Product p2=new Product("cake",BigDecimal.valueOf(533.2),LocalDate.now().plusDays(5),Condition.COLD,Rating.FOUR);
        Product p3=new Product("coke",BigDecimal.valueOf(35.34),LocalDate.now().plusDays(343),Condition.COLD,Rating.ONE);

        Deque<Product> products=new ArrayDeque<>();
        products.offerFirst(p1);
        products.offerFirst(p2);
        products.offerFirst(p3);

        int sayac=1;
        for(int i=0;i<products.size();i++){
            System.out.println(sayac);
            sayac++;
            Product temp=products.pollFirst();
            System.out.println(temp.getName());
        }
        System.out.println(products.pollFirst().getName());

        Product p4=new Product("latte",BigDecimal.valueOf(23.12),LocalDate.now().plusDays(1),Condition.HOT,Rating.ONE);

        products.offerLast(p4);
        System.out.println(products.pollLast().getName());

    }
}
