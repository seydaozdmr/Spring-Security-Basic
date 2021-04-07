package com.security.demo.Examples.OracleOCP.Exercise_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Food extends AbstractProduct{
    private LocalDate bestBefore;

    public Food(){

    }

    Food(LocalDate bestBefore) {
        super();//no args constructor of Product abstract class
        this.bestBefore = bestBefore;
    }

    Food(int id, String name, BigDecimal price, Begeni begeni, LocalDate bestBefore) {
        super(id, name, price, begeni); //passing to superclass
        this.bestBefore = bestBefore;
    }

    @Override
    public AbstractProduct applyRating(Begeni rating) {
        return new Food(getId(),getName(),getPrice(),rating,bestBefore);
    }

    @Override
    public BigDecimal getDiscount() {
        return ((bestBefore.isEqual(LocalDate.now()))?super.getDiscount() : getPrice()).setScale(2, RoundingMode.HALF_UP);
    }

    //Burası polimorfizm örneği AbstractProduct sınıfından yaratılan p3 referansı, toString olarak AbstractProduct sınıfını değil
    //food sınıfının toString metodunu kullanıyor.
    @Override
    public String toString() {
        return super.toString();
    }


    public LocalDate getBestBefore() {
        return bestBefore;
    }
}
