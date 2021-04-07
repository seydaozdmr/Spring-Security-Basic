package com.security.demo.Examples.OracleOCP.Arrays;

import com.security.demo.Examples.OracleOCP.Condition;
import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
import com.security.demo.Examples.OracleOCP.Interfaces.*;
import com.security.demo.Examples.OracleOCP.Product;
import com.security.demo.Examples.OracleOCP.Rating;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HashMapExercise2 {
    public static void main(String[] args) {
        AbstractProduct p1=new Drink(1,"tea", BigDecimal.valueOf(23.43),Begeni.FIVE_STAR);
        AbstractProduct p2=new Food(2,"cake",BigDecimal.valueOf(533.2),Begeni.THREE_STAR);
        AbstractProduct p3=new Drink(3,"coke",BigDecimal.valueOf(35.34),Begeni.ONE_STAR);
        AbstractProduct p4=new Drink(4,"latte",BigDecimal.valueOf(23.12),Begeni.FIVE_STAR);
        AbstractProduct p5=new Food(5,"cookie",BigDecimal.valueOf(23.12),Begeni.ONE_STAR);

        Review yorum1=new Review(Begeni.FOUR_STAR,"Güzel");
        Review yorum2=new Review(Begeni.FIVE_STAR,"Güzel");
        Review yorum3=new Review(Begeni.THREE_STAR,"Güzel");
        Review yorum4=new Review(Begeni.TWO_STAR,"Güzel");
        Review yorum5=new Review(Begeni.FOUR_STAR,"Güzel");
        Review yorum6=new Review(Begeni.ONE_STAR,"Güzel");
        Review yorum7=new Review(Begeni.FIVE_STAR,"Güzel");
        Review yorum8=new Review(Begeni.TWO_STAR,"Güzel");
        Review yorum9=new Review(Begeni.THREE_STAR,"Güzel");
        Review yorum10=new Review(Begeni.ONE_STAR,"Güzel");

        ProductManager productManager=new ProductManager();





    }
}
