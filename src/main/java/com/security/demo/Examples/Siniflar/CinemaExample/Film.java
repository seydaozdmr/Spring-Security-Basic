package com.security.demo.Examples.Siniflar.CinemaExample;

import java.util.Date;
import java.util.Objects;

public class Film implements Comparable<Film>{
    private int id;
    private String name;
    private Date year;
    private double rentPrice;
    private boolean isRented;

    public Film(int id, String name, Date year ,double rentPrice) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rentPrice=rentPrice;
        this.isRented=false;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public boolean isRented() {
        return isRented;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && name.equals(film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Film o) {
        if(o.getId() > this.getId()){
            return -1;
        }else if(o.getId()<this.getId()){
            return 1;
        }else{
            return 0;
        }
    }
}
