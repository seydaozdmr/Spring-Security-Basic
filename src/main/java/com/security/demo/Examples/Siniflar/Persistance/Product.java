package com.security.demo.Examples.Siniflar.Persistance;

public class Product extends Entity implements Comparable<Entity>{

    public Product(long id, String name) {
        super(id, name);
    }

    @Override
    public int compareTo(Entity o) {
        if(o.getId()>this.getId()){
            return -1;
        }else if(o.getId()<this.getId()){
            return 1;
        }else{
            return 0;
        }
    }
}
