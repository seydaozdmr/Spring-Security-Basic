package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends AbstractProduct {

    private LocalDate bestBefore;

    public Food(int id, String name, BigDecimal price, Begeni begeni) {
        super(id, name, price, begeni);
    }

    public Food(int id, String name, BigDecimal price, Begeni begeni,LocalDate bestBefore) {
        super(id, name, price, begeni);
        this.bestBefore=bestBefore;
    }



    @Override
    public Food applyRating(Begeni rating) {
        return new Food(getId(),getName(),getPrice(),rating);
    }
}
