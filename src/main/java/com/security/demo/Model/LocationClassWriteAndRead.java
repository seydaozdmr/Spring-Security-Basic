package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LocationClassWriteAndRead implements ApplicationListener<ContextRefreshedEvent> {
    private Locations locationsBase=new Locations();

    public void readLocations() {
        for(Location location:locationsBase.values()){
            System.out.println("Locations: "+location.getLocationID()+","+location.getDescription());
            for(String exit:location.getExits().keySet()){
                System.out.println("exits: "+exit+","+location.getExits().get(exit));
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //readLocations();
    }



}
