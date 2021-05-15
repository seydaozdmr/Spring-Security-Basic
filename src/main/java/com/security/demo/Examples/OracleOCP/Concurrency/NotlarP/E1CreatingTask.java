package com.security.demo.Examples.OracleOCP.Concurrency.NotlarP;

public class E1CreatingTask {
    public static void main(String[] args) {
        //Anonymous class defination
        Runnable task=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        task.run();

        Runnable task1=()-> System.out.println("hello world");
        Runnable task2=()-> {
          String message="Hello world";
            System.out.println(message);
        };
    }
}
