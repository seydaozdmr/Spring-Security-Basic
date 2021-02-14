package com.security.demo.Algoritmalar;

import java.util.Random;
import java.util.Scanner;

public class IkıliArama {
    public static void main(String[] args) {
        /*
        *İkili arama örneği:
        * Random r ile 1,63 arasında rastgele sayı tutuyoruz.
        * Daha sonra find methodu ile tutulan sayıyı bulmaya çalışıyoruz
        * her tahminde sayac değişkenimizi 1 arttırıyoruz.
        * böylece sonuc olarak 1 ya da -1 değeri döndürüyor.
        *
         */
        Random r=new Random();
        int tutulan=r.nextInt(63);
        //System.out.println(tutulan);
        //ilk tahmin 5
        System.out.println(find(5,tutulan,1,63));

    }
    public static int sayac=0;

    public static int find(int tahmin,int tutulan,int max,int min){
        //eğer ilk tahmin tutulan sayıya eşit olursa burası çalışacak ve program sonlandırılacak.
        if(tahmin==tutulan){
            System.out.println("sayac :"+sayac);
            return 1;
        }else{
            //eğer ilk tahminde bulamazsak program bizden yeni sayılar tahimin etmemizi isteyecek.
            Scanner scanner=new Scanner(System.in);
            System.out.println("tekrar tahmin edin: ");
            tahmin=scanner.nextInt();

            sayac++;  //her bir tahminde sayacı bir arttırıyoruz. sonuc olarak kaçıncı tahminde bulduğumuz ortaya çıkıyor.

            if(tahmin==tutulan) {
                System.out.println("sayac :" + sayac+". tahminde bulunmuştur...");
                return 1;
            }
            if(tahmin>tutulan){
                System.out.println("tahmin tutulandan büyük daha küçük tahmin ediniz.");
                return find(tahmin,tutulan,(max+min)/2,min);
            }else if(tutulan>tahmin){
                System.out.println("tutulan sayı tahminden büyük daha büyük tahmin ediniz.");
                return find(tahmin,tutulan,max,(max+min)/2);
            }
            return -1;
        }
    }
}
