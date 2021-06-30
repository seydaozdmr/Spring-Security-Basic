package com.security.demo.Examples.Siniflar.ProductManager;

public class ClothProduct extends Product implements Purchasable,LocatableProduct,Taxable{
    private String sex;
    private String size;
    private Location location;
    private double price;
    private double tax;

    public ClothProduct(String sku, String description, double price, double tax, String sex, String size,Location location) {
        super(sku, description);
        this.price=price;
        this.tax=tax;
        this.sex = sex;
        this.size = size;
        this.location=location;
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
        //calculateTax default method in taxalbe interface
        double endPrice = this.price + calculateTax(this.price, this.tax);
        System.out.println("kıyafet satıldı : "+price);
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

//    @Override
//    public double calculateTax(double price , double tax) {
//        return (price / 100) * tax;
//    }
}
