package com.security.demo.Examples.Siniflar;

import java.util.Comparator;

public class Ogrenci implements Comparator<Ogrenci> {
    private int id;
    private int not;

    public Ogrenci(int id, int not){
        this.id=id;
        this.not=not;
    }

    public int getId() {
        return id;
    }

    public int getNot() {
        return not;
    }


    @Override
    public int compare(Ogrenci o1, Ogrenci o2) {
        if(o1.getNot()>o2.getNot()){
            return 1;
        }else if(o1.getNot()<o2.getNot()){
            return -1;
        }else{
            return 0;
        }
    }
}
