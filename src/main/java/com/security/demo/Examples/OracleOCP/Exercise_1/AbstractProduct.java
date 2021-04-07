package com.security.demo.Examples.OracleOCP.Exercise_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public abstract class AbstractProduct {
    public static final BigDecimal DISCOUNT_RATE=BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;
    private Begeni rating;

    AbstractProduct(){
        this(0,"no name",BigDecimal.ZERO);
    }

    AbstractProduct(int id,String name,BigDecimal price,Begeni begeni){
        this.id=id;
        this.name=name;
        this.price=price;
        this.rating=begeni;
    }

    AbstractProduct(int id,String name,BigDecimal price){
        this(id,name,price,Begeni.NOT_EVALUATE);
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Begeni getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false;
        if(o instanceof AbstractProduct){
            AbstractProduct that = (AbstractProduct) o;
            return id == that.id &&
                    name.equals(that.name);
        }
        return false;

    }

    //every extend classes must override this method
    public abstract AbstractProduct applyRating(Begeni rating);

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    public BigDecimal getDiscount(){
        return this.price.subtract(this.price.multiply(DISCOUNT_RATE)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AbstractProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating.printBegeni() +
                ", best Before =" +getBestBefore()+
                '}';
    }

    public  void setPrice(BigDecimal i){
        this.price=i;
    };
}
