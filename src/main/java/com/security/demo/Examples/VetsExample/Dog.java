package com.security.demo.Examples.VetsExample;

public class Dog extends Animal {
    private String tur;
    private String cins;
    private int asiSayisi;

    public Dog(String dogumTarihi, boolean kayitli , int asiSayisi, String cins) {
        super(dogumTarihi, kayitli);
        this.asiSayisi=asiSayisi;
        this.tur="Köpek";
        this.cins=cins;
    }

    @Override
    void bilgileriGoster() {
        System.out.println(toString()+ " "+super.toString());
    }

    public int getAsiSayisi() {
        return asiSayisi;
    }

    public void setAsiSayisi(int asiSayisi) {
        this.asiSayisi = asiSayisi;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "tur='" + tur + '\'' +
                ", cins='" + cins + '\'' +
                ", asiSayisi=" + asiSayisi +
                '}';
    }
}
