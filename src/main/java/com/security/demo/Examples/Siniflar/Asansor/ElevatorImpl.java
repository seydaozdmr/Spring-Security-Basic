package com.security.demo.Examples.Siniflar.Asansor;

public class ElevatorImpl implements Elevator{
    private int id;
    private ElevatorDoor door;
    private FloorLight floorLight;
    private ControlPanel controlPanel;
    private boolean isActive;
    private Floor currentFloor;
    private Direction direction;


    public ElevatorImpl(int id) {
        this.id = id;
        this.floorLight=new FloorLight(id);
        this.controlPanel=new ControlPanel(this.id);
        this.isActive =false;
        this.currentFloor=new FloorImpl(0);
        this.door=new ElevatorDoor();
    }


    public void move(Floor floor){
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
