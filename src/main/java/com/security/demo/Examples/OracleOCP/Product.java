package com.security.demo.Examples.OracleOCP;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Product {
    public static final int MAX_EXPIRY_PERIOD=5;
    private static Period defaultExpiryPeriod;
    private String name;
    private BigDecimal price;
    private LocalDate bestBefore;

    static {
        defaultExpiryPeriod=Period.ofDays(24);
    }

    public static void setDefaultExpiryPeriod(int days){
        defaultExpiryPeriod=Period.ofDays(days);
    }

    public static Period getDefaultExpiryPeriod() {
        return defaultExpiryPeriod;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }
}
