package com.security.demo.Algoritmalar;

public class DiziFarkliElemanlar {
    public static void main(String[] args) {
        //dizi içinde tekrar eden elemanları silip yeniden başka bir dizi içinde tekil elemanları toplayan algoritma
        int [] dizi={3,3,87,56,1,87,3,2};
        int [] unique=new int[dizi.length];

        int kontrol=0;
        for(int i=0;i<dizi.length;i++){
            boolean flag=false;
            for(int j=0;j<unique.length;j++){
                if(dizi[i]==unique[j]){
                    flag=false;
                    break;
                }else{
                    flag=true;
                }
            }
            if(flag){
                unique[kontrol]=dizi[i];
                kontrol++;
            }
        }

        for(int i:unique){
            System.out.println(i);
        }
    }
}
