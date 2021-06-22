package com.security.demo.Examples.Siniflar.EnumExample;

public class Book {
    private int id;
    private String name;
    private BookType bookType;

    public Book(int id, String name, BookType bookType) {
        this.id = id;
        this.name = name;
        this.bookType = bookType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BookType getBookType() {
        return bookType;
    }
}
