package com.security.demo.Examples.OracleOCP.IOExamples.NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples3 {
    public static void main(String[] args) {
        Path path= Paths.get("C:\\test");

        Path path2=Paths.get("\\test2");
        //System.out.println(path.normalize().relativize(path2));

        try(Stream paths= Files.find(path,2,(a,b)->b.isDirectory() && !path.equals(a))){
            boolean b=paths.findFirst().isPresent();
            System.out.println(b ? "Has Sub" : "No Sub");
        }catch (IOException e){
            e.printStackTrace();
        }

        try(Stream paths2=Files.find(path,0,(p,a)->a.isSymbolicLink())){
            paths2.map(s -> s.toString()).filter(s->s.toString().endsWith(".txt"))
            .forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
