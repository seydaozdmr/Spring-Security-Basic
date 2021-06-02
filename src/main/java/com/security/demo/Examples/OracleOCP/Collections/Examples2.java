package com.security.demo.Examples.OracleOCP.Collections;

import java.util.*;

public class Examples2 {
    public static void main(String[] args) {
        Map myMap=new HashMap();
        myMap.put(1,2);
        myMap.put(3,6);

        List myList=new ArrayList();
       // myList=Arrays.copyOf(myMap.entrySet()); returns Set

        Map<Integer,Integer> testMap=new HashMap<>();
        testMap.put(1,10);
        testMap.put(2,20);
        testMap.put(3,null);

        testMap.merge(1,3,(a,b)->a+b);
        testMap.merge(2,5,(a,b)->a*b);
        testMap.merge(3,33,(a,b)->a+b);
        System.out.println(testMap);

        int sayi=0;
        System.out.println(sayi);

    }
}
