package com.security.demo.Examples.OracleOCP.Core.FutbolPackage;

import java.time.LocalDate;

public class FootballPlayer {
    private int no;
    private String name;
    private boolean inPlay;
    private int minutes;
    private int numberOfGoals;

    public FootballPlayer(int no,String name,boolean inPlay,int minutes,int numberOfGoals){
        this.no=no;
        this.name=name;
        this.inPlay=inPlay;
        this.minutes=minutes;
        this.numberOfGoals=numberOfGoals;
    }



    public void play(int minutesToPlay){
        this.minutes+=minutesToPlay;
    }

    public void score(){
        this.numberOfGoals++;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", inPlay=" + inPlay +
                ", minutes=" + minutes +
                ", numberOfGoals=" + numberOfGoals +
                '}';
    }
}
