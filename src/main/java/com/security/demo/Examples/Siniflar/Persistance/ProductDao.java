package com.security.demo.Examples.Siniflar.Persistance;

public class ProductDao extends AbstractDao<Product>{

    @Override
    public void save(Product product) {
       myMap.put(product.getId(),product);
        System.out.println("product saved");
    }

    @Override
    public void update(Product product) {
        myMap.put(product.getId(),product);
        System.out.println("product updated");
    }

    @Override
    public Product retrieve(Long id) {
        return myMap.get(id);
    }
}
