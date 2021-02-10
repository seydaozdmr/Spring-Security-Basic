package com.security.demo.Threads;

import java.io.*;

public class FileInputStreams {
    public static void main(String[] args) {
        try{
            //InputStream fileInputStream=new BufferedInputStream(new FileInputStream("data.txt"));
            DataInputStream fis=new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
