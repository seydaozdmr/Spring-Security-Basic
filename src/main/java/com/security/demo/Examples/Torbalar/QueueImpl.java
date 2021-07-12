package com.security.demo.Examples.Torbalar;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {
    public static void main(String[] args) {
        Queue<String> kuyruk=new LinkedList<>();
        kuyruk.offer("hasan");
        kuyruk.offer("hayri");
        kuyruk.offer("cem");
        kuyruk.offer("alikoc");

        System.out.println("ilk eleman: "+ kuyruk.peek());

        System.out.println("silinen eleman : "+kuyruk.poll());

        kuyruk.forEach(System.out::println);
    }
}
