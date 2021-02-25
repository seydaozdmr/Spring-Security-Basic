package com.security.demo.Examples.RasyonelSayilar;

public class RasyonelSayi {
    private int pay;
    private int payda;

    public RasyonelSayi() {
        this.pay = 0;
        this.payda=1;
    }

    public RasyonelSayi(int pay,int payda){
        int ebob=ebobBul(pay,payda);
        this.pay=pay/ebob;
        this.payda=payda/ebob;
    }

    private int ebobBul(int pay, int payda) {
        int payMutlak=Math.abs(pay);
        int paydaMutlak=Math.abs(payda);
        int ebob=1;
        for(int i=1;i<=payMutlak && i<=paydaMutlak ;i++){
            if(payMutlak%i==0 && paydaMutlak%i==0){
                System.out.println("tam bölen : "+i);
                ebob=i;
            }
        }
        return ebob;
    }

    public void yazdir(){
        System.out.println(pay+"/"+payda);
    }
}
