package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Component
public class PathsExample implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //project base directory
//        Path path= FileSystems.getDefault().getPath("WorkingDirectory.txt");
//        printFile(path);
//        //files directory
//        //Path filesPath=FileSystems.getDefault().getPath("files","SubDirectory.txt");
//        Path filesPath=FileSystems.getDefault().getPath(".","files","SubDirectory.txt");
//        printFile(filesPath);
//        //outside absolute path
//        //filesPath= Paths.get("D:\\","Examples","Outside.txt");
//        System.out.println(filesPath);
//        printFile(filesPath);
//
//        filesPath=Paths.get(".");
//        System.out.println(filesPath.toAbsolutePath());
//
//        Path path3=FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
//        System.out.println(path3.toAbsolutePath());
//        System.out.println("Path 3 exists: "+Files.exists(path3));
//
//        //Outside absolute path
//        Path path4=Paths.get("D:\\","Examples","deneme.txt");
//        printFile(path4);
//        System.out.println("Path 4 exists: "+Files.exists(path4));
//
//        //Copying files
//        Path sourceFile=FileSystems.getDefault().getPath("files","file3.txt");
//        Path copyFile=FileSystems.getDefault().getPath("files","file3copy.txt");
//        try {
//            //Files.copy(sourceFile,copyFile);
//            //Eğer dosya daha önce orada bulunuyorsa üstteki koda ekleme yapmamız gerekiyor:
//            Files.copy(sourceFile,copyFile,StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //Copying directory
////        sourceFile=FileSystems.getDefault().getPath("files","Dir1");
////        copyFile= FileSystems.getDefault().getPath("files","Dir4");
////        try{
////            Files.copy(sourceFile,copyFile,StandardCopyOption.REPLACE_EXISTING);
////        }catch (IOException e){
////            e.printStackTrace();
////        }
//
////        sourceFile=FileSystems.getDefault().getPath("files","Dir1","Dir2","file1.txt");
////        //copyFile=FileSystems.getDefault().getPath("files","Dir4","file2copy.txt");
////        try{
////            //taşıma
////            //Files.move(sourceFile,copyFile);
////            //silme:
////            Files.delete(sourceFile);
////        }catch (IOException e){
////            e.printStackTrace();
////        }
//
//        //Create file and directory
////        Path fileToCreate=FileSystems.getDefault().getPath("files","fileCreate.txt");
////        try{
////            Files.createFile(fileToCreate);
////        }catch (IOException e){
////            e.printStackTrace();
////        }
//
//        //File size
//        Path fileSize=FileSystems.getDefault().getPath("files","Dir4\\file1copy.txt");
//        try {
//            long size=Files.size(fileSize);
//            System.out.println("file size: "+size);
//            System.out.println("Last modified: "+Files.getLastModifiedTime(fileSize));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public void printFile(Path path){
        try(BufferedReader fileReader= Files.newBufferedReader(path)){
            String line;
            while((line=fileReader.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
