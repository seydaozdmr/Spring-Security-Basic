package com.security.demo.LambdaExamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example_8 {
    //Set examples-3
    public static void main(String[] args) {
        String [] liste={"i","came","i","saw","i","left"};
        Set<String> unique=new HashSet<>();
        Set<String> dubs=new HashSet<>();

        for(String a:liste){
            //burada ekleme işlemini gerçekleştiriyor eğer gerçekleştiremezse dubs listesine ekliyor.
            if(!unique.add(a)){
                dubs.add(a);
            }
        }

        unique.removeAll(dubs);
        System.out.println("Unique words : "+unique);
        System.out.println("Dublicate words: "+dubs);
    }
}
