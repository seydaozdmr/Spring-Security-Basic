package com.security.demo.Examples.Siniflar.Asansor;

public class ControlPanel {
    private int id;
    private Button targetFloor;
    private Button openDoor;
    private Button closeDoor;
    private Button emergencyButton;

    public ControlPanel(int id) {
        this.id = id;
        this.targetFloor = new ControlButton("1");
        this.openDoor = new ControlButton("open");
        this.closeDoor = new ControlButton("close");
        this.emergencyButton = new ControlButton("emergency");
    }
}
