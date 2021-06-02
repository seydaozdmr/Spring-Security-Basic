package com.security.demo.Examples.OracleOCP.Security;

import java.util.HashMap;
import java.util.Map;
//eğer sınıf için final keyword'ü kullanırsak, kötü biyetli biri sınıfımızı extend edip metodumuzu taklit edemez.
public final class Car {
    private int hp;
    private Map<String,String> userCar; //sınıf özelliklerimizi private olarak access modifier etmek zorundayız.
    //dışa açılan metotları - davranışları

    //not eğer constructor a obje referansı verirsek sınıf içindeki map için, daha sonra verdiğimiz objede değişiklik yaparsak
    //sınıf içindeki map de değişmiş olur
    public Car(int hp){
        //class içindeki propertyleri constructor ile set edebiliriz
        this.hp=hp;
    }

    //burada aracın hangi kullanıcı ile eşleşeceğini tespit ediyoruz.
    public boolean validCar(String userName,String car){
        String getCar=this.userCar.get(userName);
        return car.equals(getCar);
    }

    //eğer içerdeki map nesnesini dönersek bu nesneye ulaşıp içinde değişiklik yapılabilir
    //bunu önlemek için vekil metotlar kullanmalıyız
    public Map<String,String> getUserCar(){
        return this.userCar;
    }

    //örneğin bir value değerini dışa açmak için
    public String getCar(String user){
        return this.userCar.get(user);
    }

    //ya da nesnemizin kopyasını dışa açabiliriz

    public Map<String,String> getUserCarCopy(){
        return new HashMap<>(this.userCar);
    }
}
