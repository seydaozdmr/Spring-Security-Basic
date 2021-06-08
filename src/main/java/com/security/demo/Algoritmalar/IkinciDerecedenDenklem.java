package com.security.demo.Algoritmalar;

import java.util.Scanner;

public class IkinciDerecedenDenklem {
    public static void main(String[] args) {
        //ikinci dereceden denklemin köklerini bulma
        int a=0,b=0,c=0,delta=0;
        double x=0,y=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("a: ");
        a=scanner.nextInt();
        System.out.println("b: ");
        b=scanner.nextInt();
        System.out.println("c: ");
        c=scanner.nextInt();

        kokleriBul(a,b,c,x,y);
    }
    public static void kokleriBul(int a,int b,int c,double x,double y){
        double delta=Math.pow(b,2)-(4*a*c);
        System.out.println("delta :"+delta);
        if(delta==0){
            x=-b/2*a;
            System.out.println("tek kök vardır : "+x);
            return;
        }else if(delta<0){
            System.out.println("reel kök yok");
            return;
        }else{
            x=(-b-(Math.sqrt(delta)))/(2*a);
            y=(-b+(Math.sqrt(delta)))/(2*a);
            System.out.println("iki kök vardır : x="+x+" - y="+y);
        }
    }


}
