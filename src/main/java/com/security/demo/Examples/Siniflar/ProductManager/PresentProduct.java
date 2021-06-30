package com.security.demo.Examples.Siniflar.ProductManager;

public class PresentProduct extends Product implements LocatableProduct{
    private Location location;
    public PresentProduct(String sku, String description,Location location) {
        super(sku, description);
        this.location=location;
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
