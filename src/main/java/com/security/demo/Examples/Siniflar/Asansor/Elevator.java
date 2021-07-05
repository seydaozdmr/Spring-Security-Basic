package com.security.demo.Examples.Siniflar.Asansor;

public class Elevator {
    private int id;
    private ElevatorDoor door;
    private FloorLight floorLight;
    private ControlPanel controlPanel;
    private boolean isAction;
    private Floor currentFloor;
    private Direction direction;


    public Elevator(int id) {
        this.id = id;
        this.floorLight=new FloorLight(0);
        this.controlPanel=new ControlPanel(this.id);
        this.isAction=false;
        this.currentFloor=new Floor(0);
    }

    public boolean isAction() {
        return isAction;
    }

    public void move(Floor floor){
        if(currentFloor.getId()==floor.getId()){
            System.out.println("aynı kattasınız : "+currentFloor.getName());
        }else{
            if(floor.getId()> currentFloor.getId()){
                this.direction=Direction.UP;

            }else{
                this.direction=Direction.DOWN;
            }
            try {
                Thread.sleep(1000);
                System.out.println("Asansör "+floor.getName()+" hareket ediyor.");
                for(int i=0;i< floor.getId();i++){
                    Thread.sleep(1000);
                    System.out.print(".");
                }
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("***Asansör "+floor.getName()+" 'ta *****");
            this.currentFloor=floor;
        }

    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", door=" + door +
                ", floorLight=" + floorLight +
                ", controlPanel=" + controlPanel +
                ", isAction=" + isAction +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                '}';
    }
}
