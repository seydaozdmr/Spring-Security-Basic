package com.security.demo.Examples.OracleOCP.IOExamples.NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Examples2 {
    public static void main(String[] args) {
        //functional programming for io
        Path homePath=Paths.get("src\\main\\java\\com\\security\\demo\\Examples\\OracleOCP\\IOExamples\\NIO2\\Home");
        Path homePath2=Paths.get("src\\main\\java\\com\\security\\demo\\Examples\\OracleOCP");
        //you can use which one prefer
        try(Stream<Path> s = Files.list(homePath2)){
            s.filter(p->p.toString().endsWith(".java")).forEach(System.out::println);
            //filter(p->p.toString().equals("Shop.java")).
        }catch (IOException e){
            e.printStackTrace();
        }
        Path destination=Paths.get("src\\main\\java\\com\\security\\demo\\Examples\\OracleOCP\\IOExamples\\NIO2\\Copy2");

        //copyPath(homePath,destination);

        try {
            System.out.println(new Examples2().getPathSize(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static void copyPath(Path source,Path destination){
        try{
            Files.copy(source,destination);
            if (Files.isDirectory(source)) {
                try(Stream<Path> stream=Files.list(source)){
                    stream.forEach(p->copyPath(p,destination.resolve(p.getFileName())));
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public long size(Path p){
        try{
            return Files.size(p);
        }catch (IOException e){
            e.printStackTrace();
        }
        return 0L;
    }

    public long getPathSize(Path source) throws IOException{
        try(Stream spath=Files.walk(source)){
            return spath.filter(p-> !Files.isDirectory((Path)p))
                    .mapToLong(p->this.size((Path)p))
                    .sum();
        }
    }

    public boolean isDirectory(Path p){
        return Files.isDirectory(p);
    }


}
