package com.security.demo.Examples;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        //For collecting unique values we use set.
        //Set'ler herhangi bir value değeri olmayan Map'leri kullanıyorlar.
        //Eğer sıralama önemli değilse en hızlı yapı HashSet'dir
        // Not: Map ve Set ile çalışırken sınıfların HashCode ve Equals metotlarının override edilmesi gerekiyor performans için
        Set<String> sample=new HashSet<>();
        sample.add("Ali");
        sample.add("Hasan");
        sample.add("Ali");
        sample.add("Mehmet");
        System.out.println(sample);

        Set<String> linkSample=new LinkedHashSet<>();
        linkSample.add("Ali");
        linkSample.add("Hasan");
        linkSample.add("Ali");
        linkSample.add("Mehmet");
        System.out.println(linkSample);

        System.out.println("---ToArray---");
        //ToArray
        Object [] geciciDizi=linkSample.toArray();
        for(int i=0;i<geciciDizi.length;i++){
            System.out.println(geciciDizi[i].toString());
        }
    }
}
