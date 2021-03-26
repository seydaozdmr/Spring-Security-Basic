package com.security.demo.Examples.OracleOCP.Exercise_1;

public enum Begeni {
    ONE_STAR("*"),
    TWO_STAR("**"),
    THREE_STAR("***"),
    FOUR_STAR("****"),
    FIVE_STAR("*****"),
    NOT_EVALUATE("not evaluate");

    private final String begeni;
    Begeni(String begeni) {
        this.begeni=begeni;
    }

    public String printBegeni(){
        return begeni;
    }
}
