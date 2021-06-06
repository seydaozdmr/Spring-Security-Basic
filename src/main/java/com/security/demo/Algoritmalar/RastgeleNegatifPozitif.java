package com.security.demo.Algoritmalar;

import java.util.Random;

public class RastgeleNegatifPozitif {
    public static void main(String[] args) {
        int negatif=0, pozitif=0;
        Random random=new Random();
        for(int i=0;i<50;i++){
            int temp=random.nextInt();
            if(temp%2==0){
                pozitif++;
            }else{
                negatif++;
            }
        }
        System.out.println("pozitif : "+pozitif+ " - negatif : "+negatif);
    }
}
