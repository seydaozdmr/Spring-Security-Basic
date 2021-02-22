package com.security.demo.LambdaExamples;

import java.util.Arrays;

public class Exercise_1 {
    public static void main(String[] args) {
        String s="Let's split this up into an array";
        String [] splitted=s.split(" ");

        for(String str:splitted){
            System.out.println(str);
        }

        Runnable runnable=()->{
          String s1="Let's split this up into an array";
          String[] splitted2=s1.split(" ");
            Arrays.stream(splitted2).forEach(str1-> System.out.println(str1));
        };

        Thread myThread=new Thread(runnable);
        myThread.start();
    }
}
