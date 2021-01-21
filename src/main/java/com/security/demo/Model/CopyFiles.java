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

        //Java io.file to convert java.nio.path
//        File file=new File("files\\file3.txt");
//        Path convertedPath=file.toPath();
//        System.out.println("converted path: "+convertedPath.toAbsolutePath());
//        try{
//            Files.walkFileTree(this.sourceRoot,this);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        //Resolving paths
//        File file1=new File("C:\\Examples");
//        File resolvedFile=new File(file1,"dir\\file1.txt");
//        System.out.println("resolved path: "+resolvedFile.toPath());
//
//        resolvedFile= new File("C:\\Examples","dir\\file1.txt");
//        System.out.println("resolved path2 : "+resolvedFile.toPath());
//
//        Path parentPath=Paths.get("C:\\Examples");
//        Path childrenPath=Paths.get("dir\\file1.txt");
//        System.out.println("merging parent and children paths: "+parentPath.resolve(childrenPath));
//        System.out.println("touri: "+parentPath.toUri());
//
//        //working directory:
//        File workingDirectory=new File("").getAbsoluteFile();
//        System.out.println("working directory: "+workingDirectory.getAbsoluteFile());
//
//        System.out.println("-----print dir3 contents using list()-----");
//        File dir3Files=new File(workingDirectory,"\\files\\Dir3");
//        String [] dir3Contents=dir3Files.list();
//        for(String content:dir3Contents){
//            System.out.println(content);
//        }
//
//        System.out.println("-----print dir3 contents using listFiles()------");
//        File [] dir3FilesContents=dir3Files.listFiles();
//        for(int i=0;i<dir3Contents.length;i++){
//            System.out.println(i+ " : "+dir3FilesContents[i].getName());
//            if(dir3FilesContents[i].isDirectory()){
//                File [] tempDir=dir3FilesContents[i].listFiles();
//                for(int j=0;j< tempDir.length;j++){
//                    System.out.println(j+" : "+tempDir[j].getName());
//                }
//            }
//        }
        //Listing directory by DirectoryStream()
//        Path listingDirectory=FileSystems.getDefault().getPath("files");
//        try(DirectoryStream<Path> stream=Files.newDirectoryStream(listingDirectory)){
//            for(Path file:stream){
//                System.out.println(file.getFileName());
//            }
//        }catch (IOException | DirectoryIteratorException e){
//            System.out.println(e.getMessage());
//        }
        //recursive yap....
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
