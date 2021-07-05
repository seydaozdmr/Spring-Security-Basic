package com.security.demo.Examples.Siniflar.Asansor;

public class FloorLight implements Light {
    private int currentFloor;

    public FloorLight(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    private void SetCurrentFloor(int value){
        this.currentFloor=value;
    }
}
