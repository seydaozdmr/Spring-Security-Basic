package com.security.demo.Examples.Siniflar.CinemaExample;

import java.util.List;

public class OnlineStore {
    private String name;
    private List<Film> films;
    private List<User> subscribers;
    private double budget;

    public OnlineStore(String name , double budget) {
        this.name = name;
        this.budget=budget;
    }

    public String getName() {
        return name;
    }

    //filmler listelenir
    public List<Film> getFilms() {
        return films;
    }

    public List<User> getUsers() {
        return subscribers;
    }

    public User sellCredit(User user, double amount){
        if(user.getBudged()>amount){
            user.buyCredit(amount);
            System.out.println(user.getId()+ "kullanıcısına "+ amount+ "kredi satıldı.");
        }
        return user;
    }

    public User doSubscriber(User user){
        if(!this.subscribers.contains(user)){
            this.subscribers.add(user);
            System.out.println(user.getId()+ " " + user.getName()+ " abone oldu.");
        }
        return user;
    }

    public void rentFilm(User user,Film film){
        if(user!=null && film!=null){
            if(subscribers.contains(user)){
                if(!film.isRented()){
                    user.rentFilm(film);
                    this.budget+=film.getRentPrice();
                }else{
                    System.out.println("bu film kirada.");
                }
            }else{
                System.out.println("kullanıcı abone değil");
            }
        }
    }

    public void sellFilm(User user ,Film film){
        if(user!=null && film!=null){
            if(this.films.contains(film) && !film.isRented()){
                this.films.remove(film);
                System.out.println("film satıldı...");
            }
        }
    }
}
