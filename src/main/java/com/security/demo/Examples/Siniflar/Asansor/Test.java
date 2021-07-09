package com.security.demo.Examples.Siniflar.Asansor;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Building building=new Building();
        Floor currentFloor=building.getRandomFloor();
        System.out.println(currentFloor);

        Elevator elevator = currentFloor.callElevator(Direction.UP);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(elevator);

        int kat=0;
        boolean randomBul=false;
        while (!randomBul){
            kat = new Random().nextInt(12);
            if(kat!=elevator.getCurrentFloor()){
                randomBul=true;
            }
        }
        elevator.move(new FloorImpl(kat),new User());
    }
}
