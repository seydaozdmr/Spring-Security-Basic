package com.security.demo.LambdaExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example_2 {
    public static void main(String[] args) {
        Isci ali=new Isci("ali",23);
        Isci hasan=new Isci("hasan",44);
        Isci mustafa=new Isci("mustafa",65);
        Isci yasin=new Isci("yasin",43);

        List<Isci> isciList=new ArrayList<>();

        isciList.add(yasin);
        isciList.add(hasan);
        isciList.add(ali);
        isciList.add(mustafa);

        Collections.sort(isciList,((o1, o2) -> o1.getName().compareTo(o2.getName())));
        for(Isci i:isciList){
            System.out.println(i.getName());
        }
        String sillyString =doStringSth(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase()+s2.toUpperCase();
            }
        },isciList.get(0).getName(),isciList.get(1).getName());

        System.out.println(sillyString);
        //interface'e ait olan metodu implemente ettik.
        //interface'deki soyut metot tanımını somutlaştırdık, methodun nasıl çalışacağını ayarladık.
        UpperConcat uc=(s1,s2) -> s1.toUpperCase()+s2.toUpperCase();
        String sillyString2=doStringSth(uc,isciList.get(2).getName(),isciList.get(3).getName());
        System.out.println(sillyString2);

        //Farklı bir şekilde lambda yaratmak için
        UpperConcat uc2=(s1,s2)->{
            String result=s1.toUpperCase()+s2.toUpperCase();
            return result;
        };


    }

    public final static String doStringSth(UpperConcat uc,String s1,String s2){
        return uc.upperAndConcat(s1,s2);
    }

}


class Isci{
    private String name;
    private int age;

    public Isci(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1,String s2);
}