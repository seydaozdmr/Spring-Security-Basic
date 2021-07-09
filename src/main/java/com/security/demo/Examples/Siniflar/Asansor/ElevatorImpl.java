package com.security.demo.Examples.Siniflar.Asansor;

import java.util.ArrayList;
import java.util.List;

public class ElevatorImpl implements Elevator{
    private int id;
    private ElevatorDoor door;
    private FloorLight floorLight;
    private ControlPanel controlPanel;
    private boolean isActive;
    private Floor currentFloor;
    private Direction direction;
    private List<User> userList;


    public ElevatorImpl(int id) {
        this.id = id;
        this.floorLight=new FloorLight(id);
        this.controlPanel=new ControlPanel(this.id);
        this.isActive =false;
        this.currentFloor=new FloorImpl(0);
        this.door=new ElevatorDoor();
        this.userList=new ArrayList<>();
    }


    public void move(Floor floor,User user){
        if(currentFloor.getId()==floor.getId()){
            floorLight.setCurrentFloor(currentFloor.getId());
            System.out.println("aynı kattasınız : "+currentFloor.getName());
        }else{
            if(floor.getId()> currentFloor.getId()){
                this.direction=Direction.UP;

            }else{
                this.direction=Direction.DOWN;
            }
            int currentFloorDigit= this.currentFloor.getId();
            useElevator(user);
            try {
                Thread.sleep(1000);
                door.close();
                System.out.println("Asansör "+floor.getName()+" hareket ediyor.");
                this.isActive =true;
                for(int i=0;i< Math.abs(currentFloorDigit-floor.getId());i++){
                    Thread.sleep(1000);
                    System.out.print(".");
                    currentFloor.move(floor);
                    floorLight.setCurrentFloor(currentFloor.getId());
                    floorLight.show(currentFloor);
                }
                System.out.println();
                this.isActive =false;
                door.open();
                removeElevator();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("***Asansör "+floor.getName()+" 'ta *****");
            this.currentFloor=floor;
        }

    }

    @Override
    public boolean isFull() {
        if(this.userList.size()>=6)
            return true;
        return false;
    }

    @Override
    public void useElevator(User user) {
        if(this.userList.size()<6){
            this.userList.add(user);
        }else{
            System.out.println("asansör dolu");
        }
    }

    @Override
    public void removeElevator() {
        this.userList.clear();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor(){
        return this.currentFloor.getId();
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", door=" + door +
                ", floorLight=" + floorLight +
                ", controlPanel=" + controlPanel +
                ", isAction=" + isActive +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}
