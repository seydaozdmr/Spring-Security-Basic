package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

//Writing file example
@Component
public class LocationBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Locations locations=new Locations();
        FileWriter locFile=null;
        try{
            locFile=new FileWriter("locations.txt");
            for(Location location:locations.values()){
                locFile.write(location.getLocationID()+" , "+location.getDescription()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("işlem kapatılıyor...");
            try{
                if(locFile!=null) {
                    locFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
