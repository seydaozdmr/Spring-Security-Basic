package com.security.demo.Examples.Siniflar.Asansor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building{
    private String name;
    private List<Floor> floors;
    private static List<ElevatorImpl> elevators;

    public Building() {
        this.name = "Kodluyoruz Sigorta Şirketi";
        this.floors = new ArrayList<>();
        this.elevators = new ArrayList<>();

        for(int i=0;i<12;i++){
            floors.add(new FloorImpl(i,(i+".Kat")));
        }
        for(int i=1;i<=5;i++){
            elevators.add(new ElevatorImpl(i));
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public List<ElevatorImpl> getElevators() {
        return elevators;
    }

    public Floor getRandomFloor(){
        return this.floors.get(new Random().nextInt(12));
    }

    public static Elevator getRandomElevator(Direction direction, FloorImpl floor){
        boolean findElevator=false;
        ElevatorImpl elevator=null;
            while(!findElevator){
                elevator=elevators.get(new Random().nextInt(5));
                try {
                    Thread.sleep(100);
                    System.out.println("uygun asansör aranıyor...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(elevator.isActive() && elevator.getDirection()==direction){
                    findElevator=true;
                }else if(!elevator.isActive()){
                    findElevator=true;
                }
            }
        if(!elevator.isFull()) {
            elevator.move(floor, null);
            return elevator;
        }
        else {
            System.out.println("asansör dolu");
        }

        return null;
    }
}
