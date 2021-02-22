package com.security.demo.Examples.VetsExample;

public class Cat extends Animal{
    private String tur;
    private String cins;

    public Cat(String dogumTarihi, boolean kayitli ,String cins) {
        super(dogumTarihi, kayitli);
        this.tur="Kedi";
        this.cins=cins;
    }

    @Override
    void bilgileriGoster() {
        System.out.println("Tür : "+tur+" Cins: "+cins+ " Doğum Tarihi: "+super.getDogumTarihi()+ " Kayıtlı Mı :"+super.isKayitli());
    }
}
