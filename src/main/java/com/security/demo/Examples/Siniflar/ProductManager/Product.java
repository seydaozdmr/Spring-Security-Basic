package com.security.demo.Examples.Siniflar.ProductManager;

public abstract class Product {
    private String sku;
    private String description;


    public Product(String sku, String description) {
        this.sku = sku;
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
