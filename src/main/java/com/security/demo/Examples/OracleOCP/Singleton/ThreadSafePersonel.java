package com.security.demo.Examples.OracleOCP.Singleton;

public class ThreadSafePersonel {
    private String name;
    private static ThreadSafePersonel threadSafePersonel;

    private ThreadSafePersonel (){

    }

    public synchronized static ThreadSafePersonel getInstance(){
        if(threadSafePersonel==null){
            threadSafePersonel=new ThreadSafePersonel();
        }
        return threadSafePersonel;
    }
}
