package com.security.demo.Examples.OracleOCP.Exercise_1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductManager {

    public AbstractProduct createProduct(int id, String name, BigDecimal price, Begeni begeni, LocalDate bestBefore){
        return new Food(id,name,price,begeni,bestBefore);
    }

    public AbstractProduct createProduct(int id, String name,BigDecimal price,Begeni begeni){
        return new Drink(id,name,price,begeni);
    }
}
