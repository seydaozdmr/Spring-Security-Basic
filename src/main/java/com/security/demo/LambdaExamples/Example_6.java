package com.security.demo.LambdaExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

//Set examples-2
public class Example_6 {
    public static void main(String[] args) {
        Personel ali=new Personel("ali",23);
        Personel mehmet=new Personel("mehmet",54);
        Personel yasin=new Personel("yasin",32);
        Personel kemal =new Personel("kemal",55);


        List<Personel> list=new ArrayList<>();
        list.add(ali);
        list.add(kemal);
        list.add(yasin);
        list.add(mehmet);
        list.add(ali);
        list.add(kemal);

        //Using JDK 8 Aggregate Operations: for prints out all distinct words in its argument list.

        Set<Personel> personelSet=list.stream().collect(Collectors.toSet());
        System.out.println(personelSet.size()+ " farklı elemanlar : "+personelSet);

        Set<Personel> siraliListe=new TreeSet<>(list);
        siraliListe.stream().forEach(s-> System.out.println(s.getName()));

    }
}
