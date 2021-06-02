package com.security.demo.Examples.OracleOCP.Generics;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        System.out.println( );
        System.out.println(More.<String>identity("asd"));
        More.sink("ttt");

        List<String> liste=new ArrayList<>();
        liste.add("java");
        //More.printList(liste); bu çalışmaz çünkü bu metot Object türünde bir liste bekliyor.

        More.printList2(liste); //bu çalışır çünkü <?> wildcard bekliyor belirsiz elemanların olduğu bir liste

        List<? extends  Number> sayiListesi=new ArrayList<Integer>();

//        sayiListesi.add(Integer.valueOf(2));
//        sayiListesi.add(Integer.valueOf(34));

        List<? extends Bird> birds=new ArrayList<Bird>();
//        birds.add(new Serce());
//        birds.add(new Bird());
        List<Serce> serceler=new ArrayList<>();
        serceler.add(new Serce("serce 1"));
        serceler.add(new Serce("serce 2"));

        List<Bird> kuslar=new ArrayList<>();
        kuslar.add(new Bird("kus 1"));
        kuslar.add(new Bird("kus 2"));

        yazdir(serceler);
        yazdir(kuslar);

    }

    public static void yazdir(List<? extends Bird> birds){
        for(Bird b:birds){
            System.out.println(b.getName());
        }
    }

    static class Bird{
        String name;

        public Bird(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Serce extends Bird{

        public Serce(String name) {
            super(name);
        }
    }
}
