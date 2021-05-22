package com.security.demo.Examples.OracleOCP.Singleton;


//lazy initialization
public class Personel {
    private String name;
    private String lastName;
    private static Personel personel;

    private Personel(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public static Personel getPersonel(String name,String lastName){
        if(personel==null){
            personel=new Personel(name,lastName);
        }
        return personel;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public static void getDetay(){
        if(personel!=null){
            System.out.println(personel.getName()+" - "+personel.getLastName());
        }else {
            System.out.println("instance oluşturulmadı");
        }
    }
}
