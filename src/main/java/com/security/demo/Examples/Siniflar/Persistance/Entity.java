package com.security.demo.Examples.Siniflar.Persistance;

public abstract class Entity {
    private long id;
    private String name;


    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

//    public String getName() {
//        return name;
//    }
}
