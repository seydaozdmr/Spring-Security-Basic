package com.security.demo.Examples.OracleOCP.DateTimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeEx {
    public static void main(String[] args) {

        Locale l=Locale.FRANCE;

        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        LocalDate ld=LocalDate.of(2021, Month.AUGUST,04);
        System.out.println(ld.format(DateTimeFormatter.ofPattern("dd MMM YYYY")));
        System.out.println(ld.format(DateTimeFormatter.ISO_DATE));


    }
}
