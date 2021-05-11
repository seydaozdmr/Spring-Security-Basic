package com.security.demo.Examples.OracleOCP.Concurrency.Questions;

import java.util.ArrayList;
import java.util.List;

public class Questions3 {
    public static void main(String[] args) {
        List<String> listem=new ArrayList<>();
        listem.add("duck");  //4
        listem.add("flamingo"); //8
        listem.add("pelican"); //7
        //reduce'in ilk parametresi hangi değere indirgeyeceğimizi gösteriyor.
        //alttaki örnekte yukarıdaki liste elemanların herbirinin karakter sayısını 0'a ekliyoruz
        //eklediğimiz değerleri de s1+s2 olarak birbirine ekliyoruz

        int result=listem.parallelStream().parallel().reduce(0,(c1,c2)->c1+c2.length(),(s1,s2)->s1+s2);
        System.out.println(result);
    }
}
