package com.security.demo.Examples.Siniflar.Asansor;

public class SignalLight implements Light<Elevator>{
    private Direction direction;

    public SignalLight() {
    }

    @Override
    public void show(Elevator elevator) {
        while(elevator.isActive()){
            System.out.println("coming..");
        }
    }
}
