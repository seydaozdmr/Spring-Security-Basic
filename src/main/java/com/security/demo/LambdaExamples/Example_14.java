package com.security.demo.LambdaExamples;

import javax.xml.transform.sax.SAXSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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

        Person p1=new Person("Jack Mack", LocalDate.of(2001,7,9), Person.Cinsiyet.ERKEK,"jack@gmail.com");
        Person p2=new Person("Jane Doe",LocalDate.of(1988,12,22), Person.Cinsiyet.KADIN,"jane@gmail.com");
        Person p3=new Person("Dom Crack",LocalDate.of(1989,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");
        Person p4=new Person("Fergie Klar",LocalDate.of(2000,10,02), Person.Cinsiyet.KADIN,"fergie@gmail.com");
        Person p5=new Person("Terry Joo",LocalDate.of(2000,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");

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

        System.out.println("24 yaşından büyük personel:");
        roster.stream().filter(p->p.getAge()>24).forEach(p-> System.out.println(p.getName()));

        System.out.println("25 yaşından küçük personel");
        printPersonByAge(roster,person -> person.getAge()<25);

        Function<Person,String> upperCase=person -> person.getName().toUpperCase();
        Function<String,String> getName=name -> name.substring(0,name.indexOf(' '));
        Function concatenate=upperCase.andThen(getName);

        System.out.println("function ****");

        roster.stream().map(upperCase).forEach(System.out::println);
        System.out.println("concatenate");
        roster.stream().map(concatenate).filter(elem -> elem.toString().startsWith("J")).forEach(s-> System.out.println(s.getClass()));




    }

    public static void printPersonByAge(List<Person> personList,Predicate<Person> test){
        for(Person p:personList){
            if(test.test(p)){
                System.out.println(p.getName());
            }
        }
    }
}
