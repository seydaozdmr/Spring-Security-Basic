package com.security.demo.Examples.OracleOCP.Concurrency;

public class SynchronizedExchanger {
    private Object value;

    public synchronized void setObject(Object o){
        this.value=o;
    }

    public synchronized Object getValue(){
        return this.value;
    }
}
