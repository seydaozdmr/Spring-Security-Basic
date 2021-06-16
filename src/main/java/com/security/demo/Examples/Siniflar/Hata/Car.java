package com.security.demo.Examples.Siniflar.Hata;

public class Car {
    private int id;
    private String model;
    private String kod;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", kod='" + kod + '\'' +
                '}';
    }

    public Car(int id){
        this.id=id;
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(id);
        stringBuilder.append("-");
        if(id<10000){
            stringBuilder.append("A");
            stringBuilder.append("-Car");
            stringBuilder.append("-TR");
        }else if(id<1000000){
            stringBuilder.append("B");
            stringBuilder.append("-Car");
            stringBuilder.append("-TR");
        }else{
            stringBuilder.append("C");
            stringBuilder.append("-Car");
            stringBuilder.append("-TR");
        }
        this.kod=stringBuilder.toString();
        this.model=this.kod+ " Civic";


    }


}
