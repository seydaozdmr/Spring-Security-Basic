package com.security.demo.Examples.Siniflar.Miras;

public class Hass extends Avocado{

    private double weight;
    public static String tarla="Tarla No 1";

    static{
        System.out.println("*******************");
        System.out.println("hass static block");
        System.out.println(tarla);
    }

    {
        System.out.println("*******************");
        System.out.println("hass initialize edildi.");
    }

    public Hass(int no, String name, String type, int year, double tall) {
        super(no, name, type, year, tall);
        System.out.println("*******************");
        System.out.println("super constructor started....");

    }

    public Hass(double weight){
        this(1,"Hass","Hass",1,1);
        this.weight=weight;
        System.out.println("*******************");
        System.out.println("Hass is created");
        //burası en son işin bittiği yer
    }

    public void hassHasatZamani(){
        System.out.println("hasat zamanı aralık- hazirandır...");
    }

    @Override
    public void ilac() { //bu metot private olamaz. çünkü parenttan miras olarak alınır ve onun minumum özelliklerini taşımak zorundadır
        System.out.println("hass bazen mantar olabilir");
    }
}
