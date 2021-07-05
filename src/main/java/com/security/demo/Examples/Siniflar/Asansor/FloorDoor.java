package com.security.demo.Examples.Siniflar.Asansor;

public class FloorDoor implements Door{
    private int id;
    private Bell arrivalBell;
    private Light signalLight;
    private boolean isOpen;

    public FloorDoor() {
        this.signalLight = new SignalLight();
        this.isOpen=false;
    }

    @Override
    public void open() {
        System.out.println("floor door is opening");
        this.isOpen=true;
    }

    @Override
    public void close() {
        System.out.println("floor door is closed");
        this.isOpen=false;
    }

    @Override
    public boolean getSituation() {
        return isOpen;
    }


}
