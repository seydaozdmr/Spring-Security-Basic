package com.security.demo.Examples.Siniflar.Hata;

import java.util.LinkedList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        //OutOfMemory Example

        List<Car> list=new LinkedList<>();
        for(int i=0;i<1_000_000_000;i++){
            Car car=new Car(i);
            list.add(car);
        }

        for(int i=0;i<list.size();i++){
            if(i==9999){
                System.out.println(list.get(i));
            }
            if(i==999999){
                System.out.println(list.get(i));
            }
            if(i==1000000000){
                System.out.println(list.get(i));
            }
        }
    }
}
