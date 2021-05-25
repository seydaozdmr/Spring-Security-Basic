package com.security.demo.Examples.OracleOCP.IOExamples.NIO2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Examples {
    public static void main(String[] args) {
        Path path= Paths.get("C:\\test\\test.txt").getParent().normalize().toAbsolutePath();
        System.out.println(path.getFileName()); //current file name
        System.out.println(path);

        Path path2=Paths.get("C:\\","\\test\\test.txt");
        System.out.println(path2);
        System.out.println(path2.getFileName());

        for(int i=0;i<path2.getNameCount();i++){
            System.out.println("Element "+i+" is: "+path2.getName(i));
        }

        System.out.println("subpath(0,1) : "+path2.subpath(0,1));
        System.out.println("subpath(0,2) : "+path2.subpath(0,2));

        Path relativePath=Paths.get("\\Home");
        System.out.println(relativePath.getFileName());
        System.out.println(relativePath.isAbsolute());
        System.out.println(relativePath.getParent());
        while((relativePath=relativePath.getParent())!=null){
            System.out.println("parent : "+relativePath);
        }

        while((path=path.getParent())!=null){
            System.out.println("parent : "+path);
        }

//        Path absoluteExample=relativePath.toAbsolutePath();
//        System.out.println(absoluteExample);

//        try {
//            Path create= Files.createDirectory(Paths.get("test44"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<String> liste= new ArrayList<>();
        liste.add("Ankara");
        liste.add("İstanbul");
        liste.add("Antalya");
        liste.add("Adana");

        Path path1=Paths.get("\\Home\\test.txt");
        System.out.println(path1.getFileName());
        System.out.println(Files.exists(Paths.get(".\\")));
        Path newPath=Paths.get("src\\main\\java\\com\\security\\demo\\Examples\\OracleOCP\\IOExamples\\NIO2\\Home\\test.txt");
//        for(int i=0;i<newPath.getNameCount();i++){
//            System.out.println("Element "+i+" is: "+newPath.getName(i));
//        }
        Path main=Paths.get("test3");
        System.out.println(Files.exists(main));
        try(BufferedWriter writer=Files.newBufferedWriter(newPath)){
            for(String line:liste){
                writer.write(line);
                writer.newLine();
            }
            System.out.println("success");
        }catch (IOException e){
            e.printStackTrace();
        }

        //Dosyayı okuyoruz.
        List<String> listem=null;

        try {
            listem=Files.readAllLines(newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        listem.forEach(System.out::println);

        System.out.println(Files.isRegularFile(newPath));
        System.out.println(Files.isWritable(newPath));
        try {
            System.out.println(Files.size(newPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        


    }
}
