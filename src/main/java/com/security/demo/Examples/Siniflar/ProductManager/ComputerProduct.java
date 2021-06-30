package com.security.demo.Examples.Siniflar.ProductManager;

public class ComputerProduct implements Purchasable,LocatableProduct{
    //not taxable
    private double price;
    private Location location;

    public ComputerProduct(double price, Location location) {
        this.price = price;
        this.location=location;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public void purchase() {
        System.out.println("harici ürün bilgisayar satıldı. : "+ getPrice());
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void setLocation(Location location) {
        this.location=location;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}
