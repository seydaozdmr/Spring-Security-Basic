package com.security.demo.Examples.Siniflar.Miras;

public class Plant {
    private int no;
    private String name;
    private String type;
    private int year;

    public static String plantType="otsu odunsu";

    static {
        System.out.println("*****Plant Static Block*****");
        System.out.println("sınıfın static kısmı başlatıldı");
        System.out.println(plantType);
        sayPlant();
        System.out.println("****End of static plant***** \n");
    }

    {
        System.out.println("*********************");
        System.out.println("plant's initalize block started");
        System.out.println("*******en of initialize block plant************\n");
    }

    public Plant(int no, String name, String type, int year) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.year = year;
        System.out.println("Plant constructor.\n");
    }

    public static void sayPlant(){
        System.out.println( " this is plant");
    }

    public void bitkiBesleme(){
        System.out.println("bitkiler organik maddelerle beslenir...");
    }
}
