package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Component
public class ReadingDirectories implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //we can use filter for regular files
//        DirectoryStream.Filter<Path> filter=new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return Files.isRegularFile(entry);
//            }
//        };
//
//        //directory stream
//        Path directory= FileSystems.getDefault().getPath("files\\Dir3");
//        //try(DirectoryStream<Path> contents= Files.newDirectoryStream(directory,"*.txt")){ //yalnızca txt dosyalarını bulur
//        try(DirectoryStream<Path> contents=Files.newDirectoryStream(directory,filter)){
//            for(Path file:contents){
//                System.out.println(file.getFileName());
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        //using separator for diffirent os.
//        String separator= File.separator;
//        System.out.println(separator);
//        separator=FileSystems.getDefault().getSeparator();
//        System.out.println(separator);
//
//        //creating temp file
//        try{
//            Path tempFile=Files.createTempFile("myapp",".jpg");
//            System.out.println("Temporary file path: "+tempFile.toAbsolutePath());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        //file stores
//        System.out.println("File stores of os:");
//        Iterable<FileStore> stores=FileSystems.getDefault().getFileStores();
//        for(FileStore store:stores){
//            System.out.println(store);
//        }
//
//        //root directory
//        System.out.println("root directory");
//        Iterable<Path> rootPaths=FileSystems.getDefault().getRootDirectories();
//        for(Path path:rootPaths){
//            System.out.println(path);
//        }
    }
}
