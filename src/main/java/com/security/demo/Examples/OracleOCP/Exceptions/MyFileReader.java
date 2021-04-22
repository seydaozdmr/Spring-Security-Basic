package com.security.demo.Examples.OracleOCP.Exceptions;

public class MyFileReader implements AutoCloseable{
    private String tag;
    public MyFileReader(String value){
        this.tag=value;
    }


    @Override
    public void close() throws Exception {
        System.out.println("Closed : "+tag);
    }
}
