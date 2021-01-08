package com.security.demo.Model;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits!=null){
            this.exits=new HashMap<>(exits);
        }else
        {
            this.exits=new HashMap<>();
        }
        this.exits.put("Q",0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void addExit(String direc, int destination) {
        this.exits.put(direc,destination);
    }
}
