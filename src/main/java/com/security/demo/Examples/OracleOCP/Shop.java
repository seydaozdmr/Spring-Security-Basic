package com.security.demo.Examples.OracleOCP;

import org.springframework.security.core.parameters.P;

public class Shop {
    public static void main(String[] args) {
        Product product=new Product();
        //product.setDefaultExpiryPeriod(4);

        System.out.println(product.getDefaultExpiryPeriod());
        //defaultExpiryPeriod static variable is setted by public static final MAX_EXPIRY_PERIOD value;
        Product.setDefaultExpiryPeriod(Product.MAX_EXPIRY_PERIOD);
    }
}
