package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Component
public class JavaNIOChannel implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        try {
//            FileInputStream file=new FileInputStream("data.txt");
//            FileChannel channel=file.getChannel();
            Path dataPath= FileSystems.getDefault().getPath("data.txt");
            StringBuilder stringBuilder=new StringBuilder();
            stringBuilder.append("\nLine 9");
            stringBuilder.append("\nLine 10");
            stringBuilder.append("\nLine 11");
            Files.write(dataPath,stringBuilder.toString().getBytes("UTF-8"), StandardOpenOption.APPEND);
            List<String> lines= Files.readAllLines(dataPath);
            for(String line:lines){
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
