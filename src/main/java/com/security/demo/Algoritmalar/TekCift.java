package com.security.demo.Algoritmalar;

public class TekCift {
    public static void main(String[] args) {
        int tekToplam=0,ciftToplam=0;
        for(int i=1;i<=500;i++){
            if(i%2==0){
                ciftToplam+=i;
            }else{
                tekToplam+=i;
            }
        }
        if(tekToplam-ciftToplam>0){
            System.out.println("pozitif");
        }else{
            System.out.println("negatif");
        }
    }
}
