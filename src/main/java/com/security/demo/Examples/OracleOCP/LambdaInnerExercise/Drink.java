package com.security.demo.Examples.OracleOCP.LambdaInnerExercise;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;

import com.security.demo.Examples.OracleOCP.Interfaces.Drinkable;
import com.security.demo.Examples.OracleOCP.Interfaces.Liquid;
import com.security.demo.Examples.OracleOCP.Interfaces.Testable;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Drink extends Product implements Liquid, Testable, Drinkable {

    private int quantityOfDrinkableLiquid;

    public Drink(int quantityOfDrinkableLiquid){
        this.quantityOfDrinkableLiquid=quantityOfDrinkableLiquid;
    }

    public Drink(int id, String name, BigDecimal price, Begeni begeni, int quantityOfDrinkableLiquid) {
        super(id, name, price, begeni);
        this.quantityOfDrinkableLiquid = quantityOfDrinkableLiquid;
    }

    public Drink(int id,String name,BigDecimal price,Begeni begeni){
        super(id,name,price,begeni);
    }

    //    @Override
//    public AbstractProduct applyRating(Begeni rating) {
//        return null;
//    }

    @Override
    public void prepare() {

    }

    //have to access modifier public
    @Override
    public int measure() {
        //Static a variable
        return a;
    }

    @Override
    public void e() {

    }

    @Override
    public void consume(int quantity) {
        System.out.println(quantity+" adet, "+measure()+" kutu içecek.");
        Liquid.super.prepare();
    }


    @Override
    public int drink() {
        return quantityOfDrinkableLiquid;
    }


    @Override
    public Drink applyRating(Begeni rating) {
        return new Drink(getId(),getName(),getPrice(),rating,this.quantityOfDrinkableLiquid);
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }

    @Override
    public BigDecimal getDiscount() {
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime.getHour());
        return (localTime.isAfter(LocalTime.of(15,30))&&localTime.isBefore(LocalTime.of(18,30))) ? super.getDiscount() : BigDecimal.ZERO;
    }
}