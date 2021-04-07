package com.security.demo.Examples.OracleOCP.NestedClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TestClass {

    public static void main(String[] args) {
        InnerStaticClass innerStaticClass=new InnerStaticClass();
        innerStaticClass.createInstance("FAST");

        //nesne üzerinden değil de sınıf üzerinden static içeriğe ulaşmayı tercih ediyor
        InnerStaticClass.createInstance("NORMAL"); //yukardaki ile aynı kod.


        InnerStaticClass.StaticContext staticIcerik=new InnerStaticClass.StaticContext("SLOW");

        System.out.println(staticIcerik.getDescription());

        List<String> liste=new ArrayList<>();
        liste.add("A");
        liste.add("B");
        TextFilter filter=new TextFilter();

        //we can use InnerStaticClass's static compareText which works like Comparator's compare method.
        liste.sort(InnerStaticClass::compareText);

        //liste.sort(filter::sortText);
        //liste.sort(TextFilter::sortText); //static olmadığı için instance metot referance olmalı
        liste.forEach(System.out::println);
        liste.forEach(s-> System.out.println(s)); //same above

        //String instance method reference
        Collections.sort(liste, String::compareToIgnoreCase);
        Collections.sort(liste,(a,b) -> a.compareToIgnoreCase(b));  //same above

        //Class::static method
        liste.removeIf(s->TextFilter.removeA(s));
        liste.removeIf(s-> s.equals("A")); //same above

        liste.forEach(System.out::println);

        //object::insatnce method
        liste.removeIf(filter::removeB);
        liste.removeIf(s->s.equals("B")); //same above

        liste.forEach(System.out::println);


        liste.add("A");
        liste.add("B");

        Comparator<String> karsilastir=(a,b) ->a.compareTo(b);
        Comparator<String> karsilastir2=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); //this method belong String class which implement Comparable interface
            } //same above
        };


        Collections.sort(liste,karsilastir.reversed());
        liste.forEach(System.out::println);

        Predicate<String> metotUygula=(p)->p instanceof String; //predicate interface implementation

        Predicate<String> metotUygula2=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s instanceof  String;
            }
        }; //same above

        //negate show opposite of boolean value
        liste.removeIf(metotUygula.negate());
        System.out.println("metotUygula");
        liste.forEach(System.out::println);

    }
    public static class TextFilter{
        public static boolean removeA(String s){
            return s.equals("A");
        }

        public boolean removeB(String s){
            return s.equals("B");
        }

        public int sortText(String a,String b){
            return a.compareTo(b);
        }
    }

    public class TextFilter2{
        public boolean removeA(String s){
            return s.equals("A"); //we can use this statement by Predicate interface test method
        }

        //Nested inner class dont use static method.

//        public static int sortText(String a,String b){
//            return a.compareTo(b);
//        }
    }
}
