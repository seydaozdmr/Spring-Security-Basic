package com.security.demo.Examples.Siniflar.Asansor;

import java.util.ArrayList;
import java.util.List;

public class Building{
    private String name;
    private List<Floor> floors;
    private List<Elevator> elevators;

    public Building() {
        this.name = "Kodluyoruz Sigorta Şirketi";
        this.floors = new ArrayList<>();
        this.elevators = new ArrayList<>();

        for(int i=0;i<12;i++){
            floors.add(new Floor(i,(i+".Kat")));
        }
        for(int i=1;i<=5;i++){
            elevators.add(new Elevator(i));
        }

    }
}
