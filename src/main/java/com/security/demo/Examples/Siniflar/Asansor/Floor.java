package com.security.demo.Examples.Siniflar.Asansor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {
    private int id;
    private String name;
    private Door floorDoor;
    private List<CallButton> setOfCallButtons;

    public Floor(int id, String name) {
        this.id = id;
        this.name = name;
        this.setOfCallButtons=new ArrayList<>();
        //3 adet button
        for(int i=0;i<3;i++){
            setOfCallButtons.add(new CallButton());
        }
        this.floorDoor=new FloorDoor();
    }

    public Floor(int id){
        this(id,(id+".Kat"));
    }

    public Elevator callElevator(Direction direction){
        return Building.getRandomElevator(direction, this);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
