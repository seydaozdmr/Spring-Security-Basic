package com.security.demo.Examples.Siniflar.Asansor;

public interface Elevator {
    boolean isActive();
    int getCurrentFloor();
    void move(Floor floor);
}
