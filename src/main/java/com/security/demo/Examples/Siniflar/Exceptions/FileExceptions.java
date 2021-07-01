package com.security.demo.Examples.Siniflar.Exceptions;

import java.io.*;

public class FileExceptions {
    public static void main(String[] args) {
        openAndCloseFile("C:\\test");
    }
    private static void openAndCloseFile(String path){
        File file=new File(path);
        try{
            InputStream in=new FileInputStream(file);
            System.out.println("File opened");
            in.close();
            System.out.println("file closed");
        }catch (FileNotFoundException e){
            //özel olan exception üstte handle edilir, çünkü en geneli handle edersek direkt olarak
            //çalışır ve özel durum handle edilmez. amacının dışına çıkar...
            System.out.println("file not found : "+e.getMessage());
        }catch (IOException e){
            //eğer bu exception'ı burada handle etmezsek metot imzasında throws IOException
            //diyerek metodu çağıran yerden handle etmesini bekleyebilirim.
            System.out.println("io exception : "+e.getMessage());
        }
    }
}
