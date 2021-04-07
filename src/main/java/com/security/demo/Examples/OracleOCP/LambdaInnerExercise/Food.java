package com.security.demo.Examples.OracleOCP.LambdaInnerExercise;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Food extends Product  {

    private LocalDate bestBefore;

    public Food(int id, String name, BigDecimal price, Begeni begeni) {
        super(id, name, price, begeni);
    }

    public Food(int id, String name, BigDecimal price, Begeni begeni,LocalDate bestBefore) {
        super(id, name, price, begeni);
        System.out.println("gelen son tüketim tarihi food : "+bestBefore.toString());
        this.bestBefore=bestBefore;
    }

    //eğer getBestBefore() 'u override etmezsek base class'taki versiyonunu kullanır ki bizim istediğimiz bu değil
    @Override
    public LocalDate getBestBefore() {
        return this.bestBefore;
    }

    @Override
    public Food applyRating(Begeni rating) {
        return new Food(getId(),getName(),getPrice(),rating,this.getBestBefore());
    }


}