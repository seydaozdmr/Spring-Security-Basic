package com.security.demo.LambdaExamples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Example_13 {
    public static void main(String[] args) {
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

        Person[] rosterAsArray=roster.toArray(new Person[roster.size()]);

        //Yaşa göre sıralama yapmak için:
        //Arrays.sort(rosterAsArray,new PersonAgeComparator());

        Arrays.stream(rosterAsArray).forEach(p-> System.out.println(p.getName()));
        System.out.println("***************************");
        //Notice that the interface Comparator is a functional interface. :
        //static <T> void sort(T[] a, Comparator<? super T> c)
        //Therefore, you could use a lambda expression instead of defining
        // and then creating a new instance of a class that implements Comparator:
        Arrays.sort(rosterAsArray, (a,b)-> {
            return a.getBirthday().compareTo(b.getBirthday());
        });

        Arrays.stream(rosterAsArray).forEach(p-> System.out.println(p.getName()));

        //However, this method to compare the birth dates of two Person
        // instances already exists as Person.compareByAge.
        // You can invoke this method instead in the body of the lambda expression:
        //Person sınıfının içindeki static compareByAge methodunu kullandık..
        Arrays.sort(rosterAsArray,(a,b)-> Person.compareByAge(a,b));
        //Daha kolayı (aynı şekilde çalışır.)
        Arrays.sort(rosterAsArray,Person::compareByAge);
        //Its formal parameter list is copied from Comparator<Person>.compare, which is (Person, Person).
        //After compared byName()
        System.out.println("/*-/*-/*-/-*/*-/*-/-*/-*");
        Arrays.sort(rosterAsArray,Person::compareByName);
        Arrays.stream(rosterAsArray).forEach(p-> System.out.println(p.getName()));
    }
}

class PersonAgeComparator implements Comparator<Person>{
    public int compare(Person a,Person b){
        return a.getBirthday().compareTo(b.getBirthday());
    }
}
