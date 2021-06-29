package com.security.demo.Examples.Siniflar.AbstractAnimals;

public abstract class Animal implements ManageAnimals{
    private String name;
    private double weight;
    private int age;

    public Animal(String name, double weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Animal(){}
}
