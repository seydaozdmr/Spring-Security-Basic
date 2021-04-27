package com.security.demo.Examples.OracleOCP.DateTimes;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbers {
    public static void main(String[] args) throws ParseException {
        NumberFormat nf=NumberFormat.getInstance(new Locale("tr","TR"));
        int ziyaretci=3_200_000;
        int oran=ziyaretci/12;

        System.out.println(nf.format(oran));

        NumberFormat pf=NumberFormat.getCurrencyInstance(new Locale("tr","TR"));
        System.out.println(pf.format(1200));

        double price=234;
        NumberFormat pf2=NumberFormat.getCurrencyInstance();
        System.out.println(pf2.format(price));


        String s="40.652";
        NumberFormat nf2=NumberFormat.getInstance(new Locale("en","US"));
        System.out.println(nf2.parse(s));

        NumberFormat nf3=NumberFormat.getInstance(new Locale("fr","FR"));
        System.out.println(nf3.parse(s));

        String income="$123,564.44";
        NumberFormat anf=NumberFormat.getCurrencyInstance(new Locale("en","US"));

        System.out.println(anf.parse(income));



    }
}
