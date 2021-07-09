package com.security.demo.Examples.Siniflar.Asansor;

public interface Elevator {
    boolean isActive();
    int getCurrentFloor();
    void move(Floor floor,User user);
    boolean isFull();
    void useElevator(User user);
    void removeElevator();
}
