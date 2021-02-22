package com.security.demo.Examples.VetsExample;

public class Main {
    public static void main(String[] args) {
        Cat kedi=new Cat("01-01-2005",true,"Van Kedisi");
        kedi.bilgileriGoster();

        Dog kopek=new Dog("01-02-2006",true,5,"Çomar");
        kopek.bilgileriGoster();
    }
}
