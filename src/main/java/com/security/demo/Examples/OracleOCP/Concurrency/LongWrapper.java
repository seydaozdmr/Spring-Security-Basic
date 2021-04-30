package com.security.demo.Examples.OracleOCP.Concurrency;

public class LongWrapper {
    private Long value;
    private Object key=new Object();

    public LongWrapper(Long value){
        this.value=value;
    }

    public Long getValue(){
        return value;
    }

    public void increment(){
        synchronized (key){
            this.value+= 1;
        }

    }
}
