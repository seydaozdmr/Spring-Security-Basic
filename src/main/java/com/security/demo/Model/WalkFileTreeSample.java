package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class WalkFileTreeSample implements ApplicationListener<ContextRefreshedEvent> {
    //FileVisitorSimple Class implementation

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Path sample= FileSystems.getDefault().getPath("files");
//        FileVisitorSimple fvs=new FileVisitorSimple();
//        try {
//            Files.walkFileTree(sample,fvs);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
