package com.security.demo.Examples.OracleOCP;

import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate localTime=LocalDate.now();
        System.out.println(localTime);

        System.out.println(localTime.plusYears(1).getDayOfWeek());

        LocalTime teaTime=LocalTime.of(17,30);
        System.out.println(teaTime);

        Duration timeGap=Duration.between(LocalTime.now(),teaTime);
        System.out.println(timeGap);

        Duration timeGap2=Duration.between(LocalTime.now(),LocalTime.of(23,51));
        System.out.println(timeGap2);
        //timeGap how hour=
        System.out.println(timeGap.toHours());

        //how minutes - total minutes
        System.out.println(timeGap.toMinutes());

        //how minutes part
        System.out.println(timeGap.toMinutes()%60);

        //tomorrow of teatime
        LocalDateTime tomorrowTeaTime=LocalDateTime.of(localTime.plusDays(1),teaTime);
        System.out.println(tomorrowTeaTime);

        //ZoneId - London
        ZoneId london=ZoneId.of("Europe/London");
        //ZoneId - Katmandu
        ZoneId katmandu=ZoneId.of("Asia/Katmandu");

        ZoneId istanbul=ZoneId.of("Asia/Istanbul");

        ZonedDateTime londonTime=ZonedDateTime.of(tomorrowTeaTime,london);
        System.out.println("london: "+londonTime);

        ZonedDateTime katmanduTime=londonTime.withZoneSameInstant(katmandu);
        System.out.println("katmandu : "+katmanduTime);

        ZonedDateTime istanbulTime=londonTime.withZoneSameInstant(istanbul);

        Locale locale=Locale.UK;
        String pattern="EE' , 'd' of 'MMMM yyyy' at 'HH:mm z";
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern(pattern,locale);
        System.out.println(dateTimeFormatter);

        String timeTxt=dateTimeFormatter.format(katmanduTime);
        System.out.println(timeTxt);
        System.out.println("Istanbul : "+dateTimeFormatter.format(istanbulTime));

        Computer computer = new Laptop();
        Laptop laptop = new Laptop();
        computer.startup();
        laptop.startup();
    }


}
class Laptop extends Computer {
    public void startup() {
        System.out.print("laptop-");
    }
}

class Computer {

    public void startup() {
        System.out.print("computer-");
    }
}
