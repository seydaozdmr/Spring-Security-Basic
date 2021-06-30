package com.security.demo.Examples.Siniflar.ProductManager;

public interface Taxable {
    void setTax(double tax);
    double getTax();
    default double calculateTax(double price,double tax){
        return (price / 100 ) * tax;
    }
}
