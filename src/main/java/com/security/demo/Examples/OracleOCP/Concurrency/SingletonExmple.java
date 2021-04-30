package com.security.demo.Examples.OracleOCP.Concurrency;

public class SingletonExmple {
    private static String name;

    private SingletonExmple(){

    }

    public static synchronized String getName(String name2) throws InterruptedException {
        if(name==null){
            name=name2;
        }
        Thread.sleep(1000);
        return name;
    }
}
