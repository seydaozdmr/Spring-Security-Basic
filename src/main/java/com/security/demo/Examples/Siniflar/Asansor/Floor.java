package com.security.demo.Examples.Siniflar.Asansor;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int id;
    private String name;
    private Door elevatorDoor;
    private List<Button> setOfCallButtons;

    public Floor(int id, String name) {
        this.id = id;
        this.name = name;
        this.setOfCallButtons=new ArrayList<>();
        //3 adet button
        for(int i=0;i<3;i++){
            setOfCallButtons.add(new Button());
        }
    }
}
