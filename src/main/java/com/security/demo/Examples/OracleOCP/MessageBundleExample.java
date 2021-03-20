package com.security.demo.Examples.OracleOCP;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageBundleExample {
    public final static void main(String[] args) {
        Locale locale=new Locale("tr","TR");
        ResourceBundle bundle=ResourceBundle.getBundle("messages",locale);

        BigDecimal price=BigDecimal.valueOf(4.45);
        NumberFormat currency=NumberFormat.getCurrencyInstance(locale);
        String formattedPrice=currency.format(price);

        int quantity=10;

        LocalDate date=LocalDate.of(2021,05,05);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",locale);
        String result=formatter.format(date);
        System.out.println(result);

        String pattern= bundle.getString("urun");

        System.out.println(MessageFormat.format(pattern,"tea",formattedPrice,quantity,result));

    }
}
