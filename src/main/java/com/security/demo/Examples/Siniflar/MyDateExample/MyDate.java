package com.security.demo.Examples.Siniflar.MyDateExample;

public class MyDate {
    private Day day;
    private Month month;
    private Year year;

    private MyDate(int day,int month,int year){
        this.day=Day.values()[day-1];
        this.month=Month.values()[month-1];
        this.year=Year.getYear(year);
    }

    public static MyDate getMyDate(int day,int month,int year){
        return new MyDate(day,month,year);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
