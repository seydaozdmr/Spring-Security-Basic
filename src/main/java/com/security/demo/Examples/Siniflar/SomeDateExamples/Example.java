package com.security.demo.Examples.Siniflar.SomeDateExamples;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Example {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.plusYears(2));

        //listZoneIds();
        ZoneId zoneId=ZoneId.of("Pacific/Midway");
        ZonedDateTime zonedDateTime=ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-YYYY");
        System.out.println(zonedDateTime.format(formatter));

        LocalDate today=LocalDate.now();
        LocalDate birthDayofH=LocalDate.of(1988,7,7);
        Period period=today.until(birthDayofH);

        System.out.println(period);
    }

    private static void listZoneIds() {
        Set<String> zoneIds= ZoneId.getAvailableZoneIds();
        for(String i:zoneIds){
            System.out.println(i);
        }
    }
}
