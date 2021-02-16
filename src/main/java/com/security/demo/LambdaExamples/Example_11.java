package com.security.demo.LambdaExamples;

import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Example_11 {
    public static void main(String[] args) {
        Person p1=new Person("Jack",LocalDate.of(1988,7,9), Person.Cinsiyet.ERKEK,"jack@gmail.com");
        Person p2=new Person("Jane",LocalDate.of(1988,12,22), Person.Cinsiyet.KADIN,"jane@gmail.com");
        Person p3=new Person("Dom",LocalDate.of(1989,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");
        Person p4=new Person("Fergie",LocalDate.of(2000,10,02), Person.Cinsiyet.KADIN,"fergie@gmail.com");
        Person p5=new Person("Terry",LocalDate.of(2000,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");

        List<Person> calisanListesi=new ArrayList<>();
        calisanListesi.add(p1);
        calisanListesi.add(p2);
        calisanListesi.add(p3);
        calisanListesi.add(p4);
        calisanListesi.add(p5);

        printPersonOlderThan(calisanListesi,30);
        System.out.println();
        printPersonsWithinAgeRange(calisanListesi,20,32);

        System.out.println("Interface checkPerson");
        printPersons(calisanListesi,new checkPersonEligibleForSelectiveService());

        //Approach 4: Specify Search Criteria Code in an Anonymous Class
        System.out.println("Anonymous Class CheckPerson");
        printPersons(calisanListesi, new CheckPerson() {
            @Override
            public boolean testPerson(Person p) {
                return p.getCinsiyet()==Person.Cinsiyet.KADIN && p.getAge()>28;
            }
        });

        //Approach 5: Specify Search Criteria Code with a Lambda Expression
        //functional interface:
        System.out.println("functional interface and lambda implementation");
        printPersons(calisanListesi,(Person p)->p.getCinsiyet()== Person.Cinsiyet.ERKEK
                     && p.getAge()>25);

        //Approach 6: Use Standard Functional Interfaces with Lambda Expressions
        System.out.println("Predicate<T> is an example of a generic interface.");
        printPersonsWithPredicate(calisanListesi,(Person p)->p.getAge()>20);

        //Approach 7 The lambda expression used to print members is highlighted:
        System.out.println("approach 7:***");
        processPersons(calisanListesi,p-> p.getCinsiyet()==Person.Cinsiyet.KADIN && p.getAge()<30,p->p.printPerson());

    }

    //Approach 1: Create Methods That Search for Members That Match One Characteristic
    public static void printPersonOlderThan(List<Person> roster,int age){
        for(Person p:roster){
            if(p.getAge()>=age)
                p.printPerson();
        }
    }

    //Approach 2: Create More Generalized Search Methods
    public static void printPersonsWithinAgeRange (List<Person> roster,int minAge,int maxAge){
        for(Person p : roster){
            if(p.getAge()>=minAge && p.getAge()<maxAge){
                p.printPerson();
            }
        }
    }

    //Approach 3: Specify Search Criteria Code in a Local Class
    //We use interface for search criteria
    //we give method concrete CheckPerson interface instance
    public static void printPersons(List<Person> roster,CheckPerson checkPerson){
        for(Person p:roster){
            if (checkPerson.testPerson(p)){
                p.printPerson();
            }
        }
    }

    //Approach 6: implementation of Predicate interface
    public static void printPersonsWithPredicate(List<Person> personList,Predicate<Person> personPredicate){
        for(Person p:personList){
            if(personPredicate.test(p)){
                p.printPerson();
            }
        }
    }

    //Approach 7: Use Lambda Expressions Throughout Your Application
    public static void processPersons(List<Person> personList, Predicate<Person> personPredicate, Consumer<Person> personConsumer){
        for(Person p:personList){
            if(personPredicate.test(p)){
                personConsumer.accept(p);
            }
        }
    }
}

class Person{
    public enum Cinsiyet{
        ERKEK,KADIN
    }

    private String name;
    private LocalDate birthday;
    private Cinsiyet cinsiyet;
    private String emailAdress;

    public Person(String name, LocalDate birthday, Cinsiyet cinsiyet, String emailAdress) {
        this.name = name;
        this.birthday = birthday;
        this.cinsiyet = cinsiyet;
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public int getAge(){
        return LocalDate.now().getYear()-this.birthday.getYear();
    }

    public void printPerson(){
        System.out.println("Name: "+name+" Age: "+getAge()+" Cinsiyeti: "+cinsiyet.toString()+" Email: "+emailAdress);
    }
}



interface CheckPerson{
    boolean testPerson(Person p);
}

//CheckPerson interface implementation :
class checkPersonEligibleForSelectiveService implements CheckPerson{

    @Override
    public boolean testPerson(Person p) {
        return p.getCinsiyet()== Person.Cinsiyet.ERKEK && p.getAge()>=18 && p.getAge()<=25;
    }
}


//Approach 6: Use Standard Functional Interfaces with Lambda Expressions
//The interface Predicate<T> is an example of a generic interface.
interface Predicate<T> {
    boolean test(T t);
}