package com.security.demo.Examples.Siniflar.Asansor;

public class CallButton implements Button{
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void call(Direction direction){
        this.direction=direction;
    }
}
