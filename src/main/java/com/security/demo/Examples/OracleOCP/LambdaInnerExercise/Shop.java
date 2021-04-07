package com.security.demo.Examples.OracleOCP.LambdaInnerExercise;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

public class Shop {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ProductManager pm=new ProductManager("en-GB");
        pm.createProduct(101,"Çay", BigDecimal.valueOf(12.22), Begeni.FIVE_STAR, LocalDate.now().plusDays(100));
        pm.reviewProduct(101,Begeni.ONE_STAR,"kötü");
        pm.reviewProduct(101,Begeni.TWO_STAR,"idare");
        pm.reviewProduct(101,Begeni.THREE_STAR,"fena değil");

        pm.createProduct(102,"Kola",BigDecimal.valueOf(43.32),Begeni.THREE_STAR,LocalDate.now().plusDays(365));
        pm.reviewProduct(102,Begeni.THREE_STAR,"Fena değil");

        pm.printProduct(101);

        pm.changeLocale("tr-TR");
        pm.printProduct(101);

        pm.changeLocale("en-US");
        pm.printProduct(101);

        Comparator<Product> begeniyeGoreSirala=new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getRating().ordinal()<o2.getRating().ordinal()){
                    return -1;
                }else if(o1.getRating().ordinal()>o2.getRating().ordinal()){
                    return 1;
                }else {
                    return 0;
                }
            }
        };
        System.out.println("------Products------");
        pm.printProducts(begeniyeGoreSirala.reversed());
        System.out.println("------BestBefore------");
        pm.printProducts((o1, o2) -> o1.getBestBefore().compareTo(o2.getBestBefore()));



    }

}
