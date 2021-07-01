package com.security.demo.Examples.Siniflar.CinemaExample;

import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Film> rentedFilms;
    private double budged;
    private double credit;

    public User(int id, String name, List<Film> rentedFilms, double credit) {
        this.id = id;
        this.name = name;
        this.rentedFilms = rentedFilms;
        this.credit = credit;
        this.budged=1000;
    }

    public void rentFilm(Film film){
        this.rentedFilms.add(film);
        this.credit-=film.getRentPrice();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Film> getRentedFilms() {
        return rentedFilms;
    }

    public double getCredit() {
        return credit;
    }

    public void buyCredit(double amount){
        this.budged-=amount;
        this.credit+=amount;
    }

    public double getBudged() {
        return budged;
    }
}
