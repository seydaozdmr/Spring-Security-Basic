package com.security.demo.Examples.OracleOCP.Generics;

public class Crate<T> {
    private T contents;
    public T emptyCrate(){
        return contents;
    }

    public void packCrate(T contents){
        this.contents=contents;
    }

}
