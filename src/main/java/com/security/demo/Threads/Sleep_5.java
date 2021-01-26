package com.security.demo.Threads;

public class Sleep_5 extends Thread {

    public void run(){
        String [] array={
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        try {
            readData(array);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readData(String [] array) throws InterruptedException {
        for(int i=0; i< array.length;i++){
            Thread.sleep(4000);
            System.out.println(array[i]);
        }
    }

}
