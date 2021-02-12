package com.security.demo.Examples;

public class YazdirSinifi<T> {

    public void yazdır(T [] veri){
        for(T v:veri){
            System.out.println(v);
        }
    }
}
