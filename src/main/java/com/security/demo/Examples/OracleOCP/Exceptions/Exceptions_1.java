package com.security.demo.Examples.OracleOCP.Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions_1 {
    public static void main(String[] args) throws Exception {
        try {
            throw new IOException();
        }catch (FileNotFoundException e){
            //önce spesifik olan istisna yakalanacak.
        }catch (IOException e){

        }
        swim();

        try(MyFileReader r=new MyFileReader("seyda")){
            System.out.println("try block");
        }finally {
            System.out.println("finally block");
        }

    }

    public static void swim (){
        try{
            throw new CanNotSwimException();
        }catch (CanNotSwimException e){
            e.printStackTrace();
        }
    }
}

