package com.security.demo.Examples.Siniflar.Asansor;

import java.util.ArrayList;
import java.util.List;


public class FloorImpl implements Floor{
    private int id;
    private String name;
    private Door floorDoor;
    private List<CallButton> setOfCallButtons;

    public FloorImpl(int id, String name) {
        this.id = id;
        this.name = name;
        this.setOfCallButtons=new ArrayList<>();
        //3 adet button
        for(int i=0;i<3;i++){
            setOfCallButtons.add(new CallButton());
        }
        this.floorDoor=new FloorDoor();
    }

    public FloorImpl(int id){
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

    public void move(Floor floor) {
        if(floor.getId()>this.getId()){
            this.id++;
        }else{
            this.id--;
        }
    }
}
