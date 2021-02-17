package com.security.demo.LambdaExamples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example_14 {
    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        list1.add("hans");
        list1.add("george");
        list1.add("max");

        List<String> list2=new ArrayList<>();
        list2.add("marry");
        list2.add("harry");

        //list1.addAll(list2);

        list1.stream().forEach(p-> System.out.println(p));

        Person p1=new Person("Jack", LocalDate.of(2001,7,9), Person.Cinsiyet.ERKEK,"jack@gmail.com");
        Person p2=new Person("Jane",LocalDate.of(1988,12,22), Person.Cinsiyet.KADIN,"jane@gmail.com");
        Person p3=new Person("Dom",LocalDate.of(1989,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");
        Person p4=new Person("Fergie",LocalDate.of(2000,10,02), Person.Cinsiyet.KADIN,"fergie@gmail.com");
        Person p5=new Person("Terry",LocalDate.of(2000,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");

        List<Person> roster=new ArrayList<>();
        roster.add(p1);
        roster.add(p2);
        roster.add(p3);
        roster.add(p4);
        roster.add(p5);
        System.out.println("Lambda name list :");
        List<String> list3 = roster.stream().map(Person::getName).collect(Collectors.toList());
        list3.stream().forEach(p-> System.out.println(p));

        //erkek personelin sayısı
        Long totalMale=roster.stream().filter(person -> person.getCinsiyet()== Person.Cinsiyet.ERKEK).count();
        System.out.println("toplam erkek sayısı: "+totalMale);



    }
}
