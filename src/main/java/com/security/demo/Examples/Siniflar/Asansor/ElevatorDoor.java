package com.security.demo.Examples.Siniflar.Asansor;

public class ElevatorDoor implements Door {
    private int id;
    private boolean isOpen;

    public ElevatorDoor() {
        this.isOpen = false;
    }

    @Override
    public void open() {
        System.out.println("elevator door is openning");
        this.isOpen=true;
    }

    @Override
    public void close() {
        System.out.println("elevator door is closing");
        this.isOpen=false;
    }

    @Override
    public boolean getSituation() {
        return isOpen;
    }


}
