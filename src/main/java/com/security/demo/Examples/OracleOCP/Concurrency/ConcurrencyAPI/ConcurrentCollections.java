package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollections {
    public static void main(String[] args) {
//        Map<String,Integer> myMap=new HashMap<>();

        //you should use concurrent collection class anytime that you are going to have
        //multiple threads modify a collections object outside a synchronized block or method, even
        //if you don't expect a concurrent problem. On the other hand, immutable or read-only objects can be
        //accessed by any number of threads without a concurrent collection.
        Map<String,Integer> myMap=new ConcurrentHashMap<>();
        myMap.put("avocado" , 5);
        myMap.put("passiflora", 50);

        for(String key: myMap.keySet()){
            myMap.remove(key);

            System.out.println(Thread.currentThread().getName());

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
        }
    }
}
