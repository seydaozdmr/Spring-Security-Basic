package com.security.demo.Examples.OracleOCP.Exceptions;

public class CanNotSwimException extends Exception{
    public CanNotSwimException(){
        super();
    }

    public CanNotSwimException(Exception e){
        super(e);
    }

    public CanNotSwimException(String message){
        super(message);
    }
}
