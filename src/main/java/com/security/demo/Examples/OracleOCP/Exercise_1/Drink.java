package com.security.demo.Examples.OracleOCP.Exercise_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

public class Drink extends AbstractProduct{
    public Drink(){

    }

    public Drink(int id, String name, BigDecimal price, Begeni begeni) {
        super(id, name, price, begeni);
    }

    @Override
    public AbstractProduct applyRating(Begeni rating) {
        return new Drink(getId(),getName(),getPrice(),rating);
    }

    @Override
    public BigDecimal getDiscount() {
        LocalTime time=LocalTime.now();
        return ((time.isAfter(LocalTime.of(17,30)) && time.isBefore(LocalTime.of(18,30))) ? super.getDiscount() : getPrice()).setScale(2, RoundingMode.HALF_UP);
    }


}
