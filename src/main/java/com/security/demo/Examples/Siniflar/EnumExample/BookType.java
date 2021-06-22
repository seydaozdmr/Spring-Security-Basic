package com.security.demo.Examples.Siniflar.EnumExample;

public enum BookType {
    FICTION(1), NONFICTION(2), SCINTIFIC(3) , FANTASTIC(4);

    private static String description;
    private int no;

    static {
        description="Book type";
    }

    BookType(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public static String getDescription() {
        return description;
    }
}
