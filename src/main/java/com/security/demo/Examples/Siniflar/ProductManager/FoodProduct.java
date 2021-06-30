package com.security.demo.Examples.Siniflar.ProductManager;

import java.util.Date;

public class FoodProduct extends Product implements Purchasable,LocatableProduct , Taxable {
    private Date productionDate;
    private int life;
    private Location location;
    private double price;
    private double tax;

    public FoodProduct(String sku, String description, double price, double tax , Date productionDate,int life,Location location) {
        super(sku, description);
        this.productionDate=productionDate;
        this.life=life;
        this.location=location;
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
        System.out.println("yiyecek satıldı :" + (this.price +calculateTax(this.price,this.tax)));
    }

    @Override
    public void setLocation(Location location) {
        this.location=location;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public void setTax(double tax) {
        this.tax=tax;
    }

    @Override
    public double getTax() {
        return this.tax;
    }
}
