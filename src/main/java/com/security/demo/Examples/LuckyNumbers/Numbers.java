package com.security.demo.Examples.LuckyNumbers;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    private Map<Integer,Integer> list;
    private Random random;
    private List<Integer> keyTimes;
    private Set<Integer> lucyTen;

    public Numbers() {
        this.list=new HashMap<>();
        this.random=new Random();
        this.keyTimes=new ArrayList<>();
        this.lucyTen=new HashSet<>();
    }

    public void generateNumbers(){
        int number=0;
        for(int i=0;i<1000000;i++){
            number=random.nextInt(60);

            if(list.containsKey(number)){
                list.put(number,list.get(number)+1);
            }else{
                list.put(number,1);
            }
        }

    }

    public void writeNumbers(){
        list.forEach((k,v)-> System.out.println(k+" : "+v));
    }

    public void sortNumbers(){
        List<Integer> luckyNumbers=new ArrayList<>();
        list.forEach((k,v)->luckyNumbers.add(v));
        //Sort metodunda lambda kullandık
        Collections.sort(luckyNumbers,(s1,s2)-> s1>s2 ? 1:-1);
        Collections.reverse(luckyNumbers);
        luckyNumbers.forEach(k-> System.out.println(k));
    }

    public void generateKeyTimes(){
        for(Map.Entry<Integer,Integer> entry:list.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            for(int i=0;i<value;i++){
                keyTimes.add(key);
            }
        }
        System.out.println("Listenin büyüklüğü : "+keyTimes.size());
    }

    public void luckTen(){
        int sayac=0;
        Collections.shuffle(keyTimes);
        while(sayac<10){
            int randomNumber=random.nextInt(1000000);
            lucyTen.add(keyTimes.get(randomNumber));
            sayac++;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        lucyTen.forEach(k-> System.out.println(k));
    }
}
