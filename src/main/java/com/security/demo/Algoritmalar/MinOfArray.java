package com.security.demo.Algoritmalar;

public class MinOfArray {
    public static void main(String[] args) {
        //10 elemanlı bir dizideki en küçük eleman ve hangi sırada olduğu

        int [] dizi=new int[10];
        int index=0, min=0;
        for(int i=0;i<dizi.length;i++){
            dizi[i]=(int) (Math.random()*1000);
        }
        min=dizi[0];

        for(int i=0;i<dizi.length;i++){

            if(min>dizi[i]){
                min=dizi[i];
                index=i;
            }
        }

        System.out.println("min : "+min+ " index : "+index);
    }
}
