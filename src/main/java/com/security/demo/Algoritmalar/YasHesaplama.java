package com.security.demo.Algoritmalar;


import java.time.LocalDate;
import java.util.Scanner;

public class YasHesaplama {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Gün giriniz: ");
        String gun=scanner.nextLine();
        System.out.println("Ay giriniz: ");
        String ay=scanner.nextLine();
        System.out.println("Yıl girirniz: ");
        String yil=scanner.nextLine();

        LocalDate tarih=LocalDate.of(Integer.valueOf(yil),Integer.valueOf(ay),Integer.valueOf(gun));
        LocalDate simdi=LocalDate.now();
        LocalDate tarih2=simdi.minusYears(tarih.getYear());
        System.out.println("Yaşınız: "+tarih2.getYear());
    }
}
