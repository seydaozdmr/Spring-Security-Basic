package com.security.demo.Examples.OracleOCP.Interfaces;

import com.security.demo.Examples.OracleOCP.Exercise_1.Begeni;
//@FunctionalInterface
public interface Rateable<T> {
    public static final Begeni DEFAULT_RATING=Begeni.NOT_EVALUATE;
    T applyRating(Begeni rating);  //public abstract

    public default T applyRating(int value){
        return applyRating(convertRating(value)); //--> Rateable.convertRating(value)
    }

    //default method , particular class implements this interface , it can override this default method.
    public default Begeni getRating(){
        return DEFAULT_RATING;
    }

    public static Begeni convertRating(int value){
        return (value>=0 && value<=5) ? Begeni.values()[value] : DEFAULT_RATING;
    }




}
