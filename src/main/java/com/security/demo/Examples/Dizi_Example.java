package com.security.demo.Examples;

public class Dizi_Example {

    public static void main(String[] args) {
        int[] arr={3,-6,1,-4,4};
        diziToplami(arr);
    }

    public static int diziToplami(int [] arr){
        int toplam=0;
        int x=1;
        toplam+=x;
        for(int i=0;i<arr.length;i++){
            toplam+=arr[i];
            System.out.println("toplam : "+toplam);
            if(toplam<1){
                x+=Math.abs(toplam)+1;
                toplam+=x;
            }

            System.out.println("x: "+x);
            System.out.println("toplam 2:"+toplam);

        }
        System.out.println(toplam);
        return toplam;
    }
}
