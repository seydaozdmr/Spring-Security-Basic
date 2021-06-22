package com.security.demo.Algoritmalar;


import java.util.HashMap;
import java.util.Map;

public class DiziElemanlari {
    //dizi elemanlarının frekansını bulan algoritma
    public static void main(String[] args) {
        HashMap<Integer,Integer> myMap=new HashMap<>();
        int [] dizi= {1,2,3,4,3,7,4,5,8,1,2,4,9};

        for(int i:dizi){
            if(myMap.containsKey(i)){
                myMap.put(i,myMap.get(i)+1);
            }else{
                myMap.put(i,1);
            }
        }

        for(Map.Entry i:myMap.entrySet()){
            System.out.println(i.getKey()+" -> "+i.getValue());
        }
    }
}
