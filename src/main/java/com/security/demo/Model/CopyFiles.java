package com.security.demo.Model;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

//Our purpose coping files by FileVisitResult
@Component
public class CopyFiles extends SimpleFileVisitor<Path> implements ApplicationListener<ContextRefreshedEvent> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles() {
        this.sourceRoot = FileSystems.getDefault().getPath("files"+File.separator+"Dir1");
        this.targetRoot = FileSystems.getDefault().getPath("files"+ File.separator+"Dir3"+File.separator+"CopyDir2");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

//        Path sourcePath=FileSystems.getDefault().getPath("files"+File.separator+"Dir1"+File.separator+"Dir2"+File.separator+"fileX.txt");
//        System.out.println("source path: "+sourcePath.toAbsolutePath());
        try{
            Files.walkFileTree(this.sourceRoot,this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: "+file.toAbsolutePath()+" "+exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        //RelativizedPath source root ile source path arasındaki farkı ortaya çıkarıyor yani roottan sonra geriye kalan
        //Path'ı ayırıyor.
        //source path:"files\\Dir1\\Dir2\\fileX.txt";
        //source root:"files\\Dir1";
        //relativized root: "Dir2\\fileX.txt";
        Path relativizedPath=sourceRoot.relativize(dir);
        System.out.println("relativizedPath = "+relativizedPath);
        //target root: "files\\Dir3\\CopyDir2";
        //resolvedPathForCopy: "targetRoot.resolve(relativizedPath)" which is: "files\\Dir4\\CopyDir2\\Dir2\\fileX.txt";
        Path copyDir=targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path copy = "+copyDir);

        try{
            Files.copy(dir,copyDir);
        }catch (IOException e){
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath=sourceRoot.relativize(file);
        System.out.println("relativizedPath = "+relativizedPath);
        //target root: "files\\Dir3\\CopyDir2";
        //resolvedPathForCopy: "targetRoot.resolve(relativizedPath)" which is: "files\\Dir4\\CopyDir2\\Dir2\\fileX.txt";
        Path copyDir=targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path copy = "+copyDir);

        try{
            Files.copy(file,copyDir);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return FileVisitResult.CONTINUE;
    }
}
