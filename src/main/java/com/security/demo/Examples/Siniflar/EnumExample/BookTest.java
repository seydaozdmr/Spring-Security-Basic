package com.security.demo.Examples.Siniflar.EnumExample;

public class BookTest {

    public static void main(String[] args) {
        Book book=new Book(1,"Harry Potter",BookType.FANTASTIC);

        System.out.println(book.getBookType().getNo()+ " --- "+ BookType.getDescription());
    }
}
