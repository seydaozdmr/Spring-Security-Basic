package com.security.demo.LambdaExamples;

import java.util.*;
import java.util.stream.Collectors;

//Set examples-2
public class Example_7 {
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

        List<Personel> list2=new ArrayList<>();
        list.add(ali);
        list.add(kemal);

//        Set<Personel> s1=list.stream().collect(Collectors.toSet());
//        Set<Personel> s2=list2.stream().collect(Collectors.toSet());
        Collection<Personel> s1=new HashSet<>(list);
        Collection<Personel> s2=new HashSet<>(list2);

        if(s1.containsAll(s2)){
            System.out.println("s1 içeriyor : s2");
        }

        // s1 into the union of s1 and s2.
        Set<Personel> union = new HashSet<Personel>(s1);
        union.addAll(s2);

        // s1 into the intersection of s1 and s2
        Set<Personel> intersection = new HashSet<Personel>(s1);
        intersection.retainAll(s2);

        //s1 into the (asymmetric) set difference of s1 and s2.
        Set<Personel> difference = new HashSet<Personel>(s1);
        difference.removeAll(s2);
    }
}
