package com.security.demo.Examples.VetsExample;

abstract public class Animal {
    private String dogumTarihi;
    private boolean kayitli;

    public Animal(String dogumTarihi, boolean kayitli) {
        this.dogumTarihi = dogumTarihi;
        this.kayitli = kayitli;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public boolean isKayitli() {
        return kayitli;
    }

    public void setKayitli(boolean kayitli) {
        this.kayitli = kayitli;
    }

    abstract void bilgileriGoster();

    @Override
    public String toString() {
        return "Animal{" +
                "dogumTarihi='" + dogumTarihi + '\'' +
                ", kayitli=" + kayitli +
                '}';
    }
}
