package com.security.demo.Examples.Siniflar.ProductManager;

public class Location {
    private String depot;
    private String place;

    public Location(String depot, String place) {
        this.depot = depot;
        this.place = place;
    }

    public String getDepot() {
        return depot;
    }

    public void setDepot(String depot) {
        this.depot = depot;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
