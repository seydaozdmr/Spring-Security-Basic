package com.security.demo.Examples.Siniflar.Asansor;

public class User {
    private int id;
    private int weight;

    public User() {
        this.weight=(int)Math.random()*100;
        System.out.println("kilo : "+weight);
    }
}
