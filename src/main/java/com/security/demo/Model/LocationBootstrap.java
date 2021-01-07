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
        try {
            dosyaYaz();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Locations locations=new Locations();
        FileWriter locFile=null;
        //try içinde FileWriter nesnesi oluşturursak bu nesne try içinde kalır scope olarak.
        //Bundan dolayı nesneyi try dan önce oluşturuyoruz.
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

    public void dosyaYaz() throws IOException{
        Locations locations=new Locations();
        FileWriter fileWriter=null;

        try{
            fileWriter=new FileWriter("newLocations.txt");
            for(Location location:locations.values()){
                fileWriter.write(location.getLocationID()+ " , "+ location.getDescription()+ "\n" );

            }
        }finally {
            System.out.println("işlem kapatılıyor.");
            if(fileWriter!=null){
                fileWriter.close();
            }
        }
    }
}
