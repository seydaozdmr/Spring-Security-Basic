package com.security.demo.Examples.Torbalar;

import java.util.Stack;

public class StackImpl {
    public static void main(String[] args) {
        Stack<String> strings=new Stack<>();
        strings.push("hasan");
        strings.push("ali");
        strings.push("yasin");
        strings.push("mustafa");

        strings.forEach(System.out::println);

        //System.out.println(strings.peek());
        System.out.println(strings.size());
        int size=strings.size();
        for(int i=0;i<size;i++){
            System.out.println(strings.pop());
        }

    }
}
