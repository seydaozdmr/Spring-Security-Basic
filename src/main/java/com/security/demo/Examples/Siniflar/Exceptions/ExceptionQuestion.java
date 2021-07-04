package com.security.demo.Examples.Siniflar.Exceptions;

public class ExceptionQuestion {
    public static void main(String[] args) {
        try{
            exceptionExample();
        }catch (Exception e){
            System.out.println("catch - 2");
        }
    }

    private static void exceptionExample() throws Exception{
        try{
            System.out.println("try");
            throw new Exception();
        }catch (RuntimeException r){
            System.out.println("catch - 1");
        }finally {
            System.out.println("finally");
        }
    }
}
