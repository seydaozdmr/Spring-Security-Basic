package com.security.demo.Algoritmalar;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CharacterShift {
    public static void main(String[] args) {
        String kelime="Merhaba";
        char[] dizi=kelime.toCharArray();

        Queue<Character> kuyruk=new LinkedList<>();

        for(int i=0;i<dizi.length;i++){
            kuyruk.offer(dizi[i]);
        }

        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i< dizi.length;i++){
            char temp= kuyruk.remove();
            kuyruk.offer(temp);
            Queue<Character> copy=new LinkedList<>(kuyruk);
            for(int j=0;j<dizi.length;j++){
                stringBuilder.append(copy.remove());
            }
            System.out.println(stringBuilder.toString());
            stringBuilder.delete(0,dizi.length);

        }

    }
}
