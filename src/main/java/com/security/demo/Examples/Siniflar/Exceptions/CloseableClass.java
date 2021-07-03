package com.security.demo.Examples.Siniflar.Exceptions;


public class CloseableClass implements AutoCloseable {
    private String name;
    private boolean open;

    public CloseableClass(String name , boolean b) {
        System.out.println("cloaseable object is constructed : "+name);
        this.name = name;
        open=true;
        if(b){
            System.out.println("throwing a runtime exception ");
            throw new RuntimeException();
        }

    }

    @Override
    public void close() throws Exception {
        System.out.println("closing closableclass object : "+name );
        open=false;
    }

    public void doSomething(){
        System.out.println("doing something");
    }

    public boolean isOpen() {
        return open;
    }
}
