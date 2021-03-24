package com.security.demo.Examples.OracleOCP;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;  //static import
import java.time.LocalDate;
import java.time.Period;
import  static com.security.demo.Examples.OracleOCP.Condition.*;

public class Product implements Comparable<Product> {
    public static final BigDecimal DISCOUNT_RATE=BigDecimal.valueOf(0.1);
    public static final int MAX_EXPIRY_PERIOD=5;
    private static Period defaultExpiryPeriod;
    private String name;
    private BigDecimal price=BigDecimal.valueOf(0);
    private LocalDate bestBefore;
    private Condition condition;
    private Rating rating;

    public Product(){
        //we are assigning default values while class initialize no args constructor.
        this("no name",BigDecimal.ZERO,LocalDate.now(), WARM);
    } //default constructor

    public Product(String name,BigDecimal price,LocalDate bestBefore,Condition condition,Rating rating){
        this. name=name;
        this.price=price;
        this.bestBefore=bestBefore;
        this.condition=condition;
        this.rating=rating;
    }

    public Product(String name, BigDecimal price,LocalDate bestBefore,Condition condition){
        this(name,price,bestBefore,condition,Rating.FOUR);
    }

//    public Product(){
//        //default constructor
//    }
        //overloading constructor
    public Product(String name){
        this.name=name;
        this.condition=COLD;
    }

    static {
        defaultExpiryPeriod=Period.ofDays(24);
    }

//    public static void setDefaultExpiryPeriod(int days){
//        defaultExpiryPeriod=Period.ofDays(days);
//    }

    public static Period getDefaultExpiryPeriod() {
        return defaultExpiryPeriod;
    }


    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    //metot overloading
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//    public void setPrice(double price){
//        this.price=BigDecimal.valueOf(price);
//    }


    public LocalDate getBestBefore() {
        return bestBefore;
    }

//    public void setBestBefore(LocalDate bestBefore) {
//        this.bestBefore = bestBefore;
//    }

    public BigDecimal getDiscount(){

        return price.subtract(price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP));
    }

    public Rating getRating() {
        return rating;
    }


    @Override
    public int compareTo(Product o) {
        if(this.rating.ordinal()>o.getRating().ordinal()){
            return -1;
        }else if(this.rating.ordinal()<o.getRating().ordinal()){
            return 1;
        }else {
            return 0;
        }
    }
}
