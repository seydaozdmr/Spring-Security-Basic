package com.security.demo.Examples.Siniflar.ProductManager;

public class ConsultancyProduct extends Product implements Purchasable,Taxable{
    private double price;
    private double tax;

    public ConsultancyProduct(String sku, String description, double price, double tax) {
        super(sku, description);
        this.price=price;
        this.tax=tax;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void purchase() {
        System.out.println("danışmanlık ücreti : "+this.price+this.tax);
    }

    @Override
    public void setTax(double tax) {
        this.tax=tax;
    }

    @Override
    public double getTax() {
        return this.tax;
    }

    @Override
    public double calculateTax(double price, double tax) {
        return 0;
    }
}
