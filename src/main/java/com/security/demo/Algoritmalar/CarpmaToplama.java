package com.security.demo.Algoritmalar;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Scanner;

public class CarpmaToplama {
    //Çarpma işlemini toplama kullanarak bulan programın algoritma ve akış diyagramını çiziniz.
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.Sayıyı giriniz: ");
        int a=scanner.nextInt();
        System.out.println("2.Sayıyı giriniz: ");
        int b=scanner.nextInt();
        int toplam=0;
        for(int i=0;i<a;i++){
            toplam+=b;
        }
        System.out.println("toplam :"+toplam);
    }


}
