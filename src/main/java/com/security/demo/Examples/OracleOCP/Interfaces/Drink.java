package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;

import java.math.BigDecimal;

public class Drink extends AbstractProduct implements Liquid,Testable,Drinkable {

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
}
