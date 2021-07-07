package com.security.demo.Examples.Siniflar.Asansor;

public class FloorLight implements Light<Floor> {
    private int currentFloor;

    public FloorLight(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setCurrentFloor(int value){
        this.currentFloor=value;

    }

    @Override
    public void show(Floor floor) {
        System.out.print("*"+currentFloor+"* ");
    }


}
