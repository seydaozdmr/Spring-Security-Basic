package com.security.demo.Examples.OracleOCP.StreamsExample;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.LambdaInnerExercise.Drink;
import com.security.demo.Examples.OracleOCP.LambdaInnerExercise.Product;
import com.security.demo.Examples.OracleOCP.LambdaInnerExercise.ProductManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class ConsumerExercise {
    public static void main(String[] args) {
        Consumer<Product> expireProduct=product -> product.setBestBefore(LocalDate.now());
        Consumer<Product> discountProduct=product -> product.setDiscount(BigDecimal.valueOf(0.1));

        ProductManager pm=new ProductManager("en-GB");
        pm.createProduct(101,"Çay", BigDecimal.valueOf(12.22), Begeni.FIVE_STAR, LocalDate.now().plusDays(100));
        pm.reviewProduct(101,Begeni.ONE_STAR,"kötü");
        pm.reviewProduct(101,Begeni.TWO_STAR,"idare");
        pm.reviewProduct(101,Begeni.THREE_STAR,"fena değil");

        pm.createProduct(103,"Ice Tea", BigDecimal.valueOf(12.22), Begeni.FIVE_STAR, LocalDate.now().plusDays(100));
        pm.reviewProduct(101,Begeni.FIVE_STAR,"kötü");


        pm.createProduct(102,"Kola",BigDecimal.valueOf(43.32),Begeni.THREE_STAR,LocalDate.now().plusDays(365));
        pm.reviewProduct(102,Begeni.THREE_STAR,"Fena değil");

        pm.createProduct(104,"Kahve",BigDecimal.valueOf(43.32),Begeni.ONE_STAR);

        List<Product> liste= new ArrayList<>(pm.getPmHashMap().keySet());

//        liste.forEach(expireProduct);
//        liste.forEach(expireProduct.andThen(discountProduct));
        liste.forEach(p-> System.out.println(p));

        //bazen bazı işlemleri ortada bazı işlemleri ise filtreden geçirdikten sonra uygulamak isteyebiliriz

        Comparator<Product> fiyatSirala=(p,q)-> p.getPrice().intValue()-q.getPrice().intValue();
        liste.stream().peek(expireProduct).sorted(fiyatSirala).filter(p-> p.getPrice().compareTo(BigDecimal.valueOf(5))>0)
                .forEach(discountProduct);
        liste.forEach(System.out::println);
        liste.sort(fiyatSirala);
        liste.forEach(System.out::println);

        //Function<T,R> sample
        Function<Product,String> nameMapper=(p)->p.getName();
        UnaryOperator<String> trimMapper=(p)->p.trim();
        ToIntFunction<String> lengthMapper=p->p.length();
        int uzunluk=liste.stream().map(nameMapper.andThen(trimMapper)).mapToInt(lengthMapper).sum();
        System.out.println(uzunluk);

        System.out.println("------max");
        Optional<Product> p4= liste.stream().max((p,q)->-p.getName().compareTo(q.getName()));
        Product p1=p4.isPresent() ? p4.get() : null;
        System.out.println(p1);

        List<Product> drinkList= liste.stream().filter(p-> p instanceof Drink).collect(Collectors.toList());
        System.out.println("-----collect");
        drinkList.stream().forEach(System.out::println);
    }
}
