package com.security.demo.Examples.Siniflar.AbstractAnimals;

import java.time.LocalTime;

public class Rodents extends Animal{
    public Rodents(String name, double weight, int age) {
        super(name, weight, age);
    }

    public Rodents() {
    }

    @Override
    public void getDosage() {
        System.out.println("rodents dosage");
    }

    @Override
    public long getFeedSchedule() {
        return LocalTime.of(3,0).getMinute();
    }
}
