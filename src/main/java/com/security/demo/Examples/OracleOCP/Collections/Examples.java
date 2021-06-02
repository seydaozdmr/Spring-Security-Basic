package com.security.demo.Examples.OracleOCP.Collections;

import javax.swing.text.ChangedCharSetException;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Examples {
    public static void main(String[] args) {
        //? super alt sınırı belirliyor.
        HashSet<? super EOFException> e=new HashSet<Exception>();
        HashSet<? super EOFException> e2=new HashSet<IOException>();
        //ilk örnekte EOFException en alt sınıfı belirliyor. Hashset'e eklenebilecek elemanların türünü sınırlarken
        //ki generics'in mantığı sınıfı sınırlamak ve tür olarak kesinleştirmektir. Bu sayede tip hatalarının önüne geçilir
        //ikinci örnekte ise EOFException alt sınırı kendisinden üstte bulunan IOException tipindeki sınıfları e2 Hashset'ine ekleyebilmemize
        //olanak sağlıyor


        //? extends üst sınırı belirliyor
        HashSet<? extends Number> list=new HashSet<Integer>();
        HashSet<? extends Number> list2=new HashSet<AtomicInteger>();
        //ilk örnekte Number en üst sınırı belirliyor. list Hashsetine eklenebilecek en üst sınır Number oluyor karşılık olarak
        //number sınıfının genişletilmesiyle (extend) oluşturulan Integer tipindeki elemenların eklenebileceğini görüyoruz.
        //ikinci örnek de aynı mantık geçerli







    }
}
