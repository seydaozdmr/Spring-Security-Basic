package com.security.demo.LambdaExamples;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example_16 {
    public static void main(String[] args) {
        Person p1=new Person("Jack Mack", LocalDate.of(2001,7,9), Person.Cinsiyet.ERKEK,"jack@gmail.com");
        Person p2=new Person("Jane Doe",LocalDate.of(1988,12,22), Person.Cinsiyet.KADIN,"jane@gmail.com");
        Person p3=new Person("Dom Crack",LocalDate.of(1989,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");
        Person p4=new Person("Fergie Klar",LocalDate.of(2000,10,02), Person.Cinsiyet.KADIN,"fergie@gmail.com");
        Person p5=new Person("Terry Joo",LocalDate.of(2000,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");

        Department hal=new Department("Hal");
        hal.addPerson(p1);
        hal.addPerson(p2);
        hal.addPerson(p3);

        Department pazar=new Department("Pazar");
        pazar.addPerson(p4);
        pazar.addPerson(p5);

        List<Department> departments=new ArrayList<>();
        departments.add(hal);
        departments.add(pazar);

        departments.stream().flatMap(department -> department.getPersonList().stream())
                .forEach(System.out::println);

        //Örneğim belirli yaştaki personeli listelemek için collect içerisinde grouppingBy kullanabiliriz.

        Map<Integer,List<Person>> groupByAge= departments
                .stream()
                .flatMap(department -> department.getPersonList().stream())
                .collect(Collectors.groupingBy(person -> person.getAge()));

        groupByAge.forEach((integer,person)-> System.out.println(integer+" . yaşındaki elemanlar: "+person));


    }
}

class Department{
    private String name;
    private List<Person> personList;

    public Department(String name) {
        this.name = name;
        this.personList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void addPerson(Person p){
        this.personList.add(p);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
