package com.security.demo.LambdaExamples;

import java.util.*;
import java.util.stream.Collectors;

//Set examples-1
public class Example_5 {
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
        System.out.println("listenin ilk hali  : ");
        list.stream().forEach(personel -> System.out.println(personel.getName()+" - "+personel.getAge()));

        //ArrayList -> HashSet olarak değiştiriliyor
        Collection<Personel> personelSet=new HashSet<>(list);
        System.out.println("HashSet örneği : ");
        for(Personel p:personelSet){
            System.out.println(p.getName());
        }
        System.out.println("Lambda****************");
        personelSet.stream().forEach(personel -> System.out.println(personel.getName()));

        System.out.println("list.stream().collect() metodu ile set haline getirdikten sonra forEach ile yazdırıyoruz");
        list.stream().collect(Collectors.toSet()).forEach(personel -> System.out.println(personel.getName()));

        System.out.println("ilk listenin size() : "+list.size());

        Set<String> s=list.stream()
                .map(Personel::getName)
                .collect(Collectors.toSet());
        System.out.println("Set ile person.getName() elemanlarını liste haline getiriyoruz.");
        s.stream().forEach(person -> System.out.println(person));

        //Liste elemanlarının sırasını bozmadan tekrar eden elemanları silmek içim :
        Collection<Personel> liste=new LinkedHashSet<>(list);
        System.out.println("LinkedHashSet örneği *****");
        liste.stream().forEach(personel -> System.out.println(personel.getName()+" "+personel.getAge()));

        System.out.println( "removeDups metodu ile uygulanmış bir örnek:");
        Set<Personel> deneme=removeDups(list);
        deneme.stream().forEach(p -> System.out.println(p.getName()));

    }

    public static <E> Set<E> removeDups(Collection<E> list){
        return new LinkedHashSet<E>(list);
    }

}
