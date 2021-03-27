package com.security.demo.Examples.OracleOCP.Exercise_1;

public enum Begeni {
    NOT_EVALUATE("not evaluate"),
    ONE_STAR("*"),
    TWO_STAR("**"),
    THREE_STAR("***"),
    FOUR_STAR("****"),
    FIVE_STAR("*****");

    private final String begeni;
    Begeni(String begeni) {
        this.begeni=begeni;
    }

    public String printBegeni(){
        return begeni;
    }
}
