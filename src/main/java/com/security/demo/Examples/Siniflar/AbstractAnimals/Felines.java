package com.security.demo.Examples.Siniflar.AbstractAnimals;

import java.time.LocalTime;

public class Felines extends Animal{

    public Felines(String name, double weight, int age) {
        super(name, weight, age);
    }

    public Felines() {
    }

    @Override
    public void getDosage() {
        System.out.println("feniles dosage");
    }

    @Override
    public long getFeedSchedule() {
        return LocalTime.of(1,0).getMinute();
    }
}
