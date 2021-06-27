package com.security.demo.Examples.Siniflar.Miras;

public class Test {

    public static void main(String[] args) {
//        //static bir değişkene ulaşınca Sınıf başlatıldı (static üyeleri ve nesneleri)
//        String plantType= Plant.plantType;
//        //sınıf yüklendikten sonra sınıftan yeni bir nesne yarattık fakat static kısımları tekrar yaratılmadı
//        Plant plant=new Plant(2,"Kaktüs","Kaktüs",2);
//        Plant plant1=new Plant(3,"Squart","Kaktüs",3);
//        //initialize blokları ve constructor blokları 2 kez çalıştı.
//
//        //Şimdi bir avocado nesnesi yaratıyouz.
//        System.out.println("*********Avocado**********");
//        //static bilgisi çağırmayacağız
//        Avocado avocado=new Avocado(4,"Fuerte","Avocado",1, 2.0);
//        //avocadonun static memberları initialize ediliyor ve static block çalışıyor
//        //daha sonra plant'ın initialize blockları ve constructoru çalışıyor
//        //en son avocadonun initialize blockları ve constructoru önce this() olan'dan başlamak üzere this() çalıştırıldıktan sonra
//        //içinde this() olan constructor çalışması bitiriliyor.
//
//        //Hass
//        System.out.println("\n***********Hass***********");
//           Hass hass=new Hass(2); //yalnızca ağırlık giriyorum
//        System.out.println(Hass.tarla);
//        //burada sadece plant içindeki static nesneyi tetikliyorum
//        //Plant.sayPlant();
//        //bu durumda da Sınıfın static üyeleri ve static block çalıştırılıyor.

        //Avocado avocado=new Avocado(1,"Zutano","Zutano",1,10);

        /**
         * 1-önce sınıflar yükleniyor (parentlar önce daha sonra sub class'ın) ve sınıflara ait olan static alanlarla static blocklar
         * 2-parent sınıfların initialize blokları ve devamında constructorları
         * 3-en son sub class'ımızın initialize bloğu ve constructor'u
         */

        /**
         * miras alınan instance metot override edilebilir (instance metot olarak)
         * miras alınan static metot gizlenebilir
         * miras alınan instance metot static olarak override edilemez
         * miras alınan static metot instance olarak gizlenemez ya da override edilemez
         * çünkü instance olması için nesnenin yaratılması gerekir oysa ki static content nesne
         * yaratılmadan sınıf üzerinden kullanılabilir. bu karşılıklık yaratacağı için bu kurallar geçerli.
         */

        //Bir istemci üst sınıftan neye ulaşabiliyorsa alt sınıftan da en azından ona ulaşabilmeli;
//        Plant plant=new Hass(250);
//        plant.bitkiBesleme();
        //bitki besleme aynı zamanda Hass'ın da miras aldığı bir metotdur
        //plant genel bilgileri içerir hass ise özel dolaysıyla hass plant'ın genel bilgilerine sahiptir
        //bu kullanımda plant nesnesi hass a ait üye nesnelerine ya da özelliklerine (property) leri erişemez.
        //vekil olarak parentten child'e miras olarak geçen metotlar childde gizlenemez

        Plant p=new Hass(2,"MyAvocado","Hass",2,2);

        Avocado av=new Avocado(3,"avocado","notype",5,6.0);
        System.out.println(av);
        System.out.println("*************");
        //down casting daha genel bir referansın daha özel bir türe dönüştürülmesi
        //örneğimizde p is a Plant
        //ama gösterdiği nesne Hass
        //bundan dolayı biz genel olan p'yi daha özel olan alttaki tiplere cast edebiliyoruz.
        if(p instanceof Hass){
            System.out.println("p is a Hass");
        }
        if(p instanceof Avocado){
            System.out.println("p is a avocado");
            av=(Avocado) p;
        }
        if(p instanceof Plant){
            System.out.println("p is a Plant");
        }
        System.out.println("***********************");
        System.out.println(av);





    }
}
