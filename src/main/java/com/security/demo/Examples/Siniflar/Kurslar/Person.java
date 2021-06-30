package com.security.demo.Examples.Siniflar.Kurslar;

public abstract class Person {
    private String name;
    private String description;
    private String userName;

    public Person(String name, String description, String userName) {
        this.name = name;
        this.description = description;
        this.userName = userName;
    }
    public Person(){}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
