package com.security.demo.Examples.OracleOCP.FunctionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Example_3 {
    public static void main(String[] args) {
        Predicate<Integer> predicate=i-> i>10;
        System.out.println(predicate.test(12));

        List<insan> insans=new ArrayList<>();
        insans.add(new insan("Ali","Mali",12,Cinsiyet.MALE));
        insans.add(new insan("Hasan","Basri",25,Cinsiyet.MALE));
        insans.add(new insan("Mustafa","Kadir",20,Cinsiyet.MALE));
        insans.add(new insan("Hatice","Norcu",30,Cinsiyet.FEMALE));
        insans.add(new insan("Gülay","Norcu",50,Cinsiyet.FEMALE));
        insans.add(new insan("Hasan","Kaldırım",16,Cinsiyet.MALE));

        //System.out.println(insans.stream().filter(p->p.getName().startsWith("M")).count());
        insans.stream()
                .filter(p->p.getCinsiyet()==Cinsiyet.FEMALE)
                .map(item->item.getName().length())
                .filter(i->i>4)
                .forEach(System.out::println);
    }
}

enum Cinsiyet{
    MALE,
    FEMALE
}

class insan{
    private String name;
    private String lastName;
    private Integer age;
    private Cinsiyet cinsiyet;

    public insan(String name, String lastName, Integer age, Cinsiyet cinsiyet) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cinsiyet = cinsiyet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
}
