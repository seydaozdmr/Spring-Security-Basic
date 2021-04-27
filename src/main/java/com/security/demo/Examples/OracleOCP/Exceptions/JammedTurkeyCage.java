package com.security.demo.Examples.OracleOCP.Exceptions;

public class JammedTurkeyCage implements AutoCloseable{
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }

    public static void main(String[] args) {
//        try(JammedTurkeyCage t=new JammedTurkeyCage()){
////            System.out.println("put turkeys in cage");
////        }catch (IllegalStateException e){
////            System.out.println("Caught :"+ e.getMessage());
////        }
        int num=-5;
        assert num>0;
        System.out.println(num);
    }
}
