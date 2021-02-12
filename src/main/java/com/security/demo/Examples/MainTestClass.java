package com.security.demo.Examples;

import java.io.ObjectInputStream;

public class MainTestClass {
    public static void main(String[] args) {
        String [] isimler={"ali","hasan","yılmaz"};
        Integer[] sayilar={1,2,3,4};
        Character[] karakterler={'a','l','i'};

        YazdirSinifi<String> yazdir=new YazdirSinifi<>();
        yazdir.yazdır(isimler);

        YazdirSinifi<Integer> yazdirsayi=new YazdirSinifi<>();
        yazdirsayi.yazdır(sayilar);

        yazdir(karakterler);
    }
    //Generic method kullanımı
    //eğer extends kullanırsam T extend ettiğim sınıfın elemanı olmak zorundadır...
    public static <T extends Character>  void yazdir(T [] dizi){
        for(T o:dizi){
            System.out.println(o);
        }
    }
}
