package com.security.demo.Examples.OracleOCP.Core.FutbolPackage;

public class FootballPlayerTest {
    public static void main(String[] args) {
        FootballPlayer alex=new FootballPlayer(10,"Alex De Souza",true,0,0);
        alex.play(90);
        alex.score();
        alex.score();

        System.out.println(alex);
        String name1="alex";
        String name2="alex";
        System.out.println(name1==name2); //sabite pool içinde bulunur
    }
}
