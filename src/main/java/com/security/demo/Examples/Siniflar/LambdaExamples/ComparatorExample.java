package com.security.demo.Examples.Siniflar.LambdaExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("Seyda");
        names.add("Hasan");
        names.add("Zekeriya");
        names.add("Ali");
        names.add("Arif");
        names.add("Kazım");

        System.out.println("before");
        for(String i:names){
            System.out.println(i);
        }

        Collections.sort(names,(s1,s2)->s1.compareTo(s2));

        System.out.println("after");
        for(String i:names){
            System.out.println(i);
        }

        Comparator<String> karsilastir=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }else if(o1.length()<o2.length()){
                    return -1;
                }else{
                    return 0;
                }
            }
        };
        System.out.println("karakter uzunluğuna göre");
        Collections.sort(names,karsilastir);
        for(String i:names){
            System.out.println(i);
        }

    }
}
