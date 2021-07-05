package com.security.demo.Examples.Siniflar.Asansor;

import java.util.List;

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

    }
}
