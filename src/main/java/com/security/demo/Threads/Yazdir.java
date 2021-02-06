package com.security.demo.Threads;

public class Yazdir {
    public static void main(String[] args) {
        Yaz yaz=new Yaz(10);
        John john=new John(yaz);
        Matt matt=new Matt(yaz);

        john.start();
        matt.start();
    }
}

class Yaz{
    private int dokumanSayisi;
    //Eğer i değerini local olarak tanımlamazsak iki thread de aynı değeri kullanırlar
    //fonksiyon içerisindeki döngüde tanımlarsak her bir thread kendi stack'inde bu değeri kullanır.
    private int i;
    public Yaz(int dokumanSayisi) {
        this.dokumanSayisi = dokumanSayisi;
    }
    //eğer methodu synchronized yaparsam her bir thread ayrı ayrı fonksiyonu kullanır.
    public synchronized void yaz(){
        //synchronized (this) sadece istediğimiz bir bloğu kilitleyebiliriz.
        for(i=dokumanSayisi;i>0;i--){
            System.out.println(i+". Döküman yazdırılıyor Thread name: "+Thread.currentThread().getName());
        }
    }
}

class John extends Thread{
    private Yaz yaz;

    public John(Yaz yaz) {
        this.yaz = yaz;
    }

    public void run(){
        yaz.yaz();
    }
}

class Matt extends Thread{
    private Yaz yaz;

    public Matt(Yaz yaz) {
        this.yaz = yaz;
    }
    public void run(){
        yaz.yaz();
    }
}

