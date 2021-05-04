package com.security.demo.Examples.OracleOCP.Concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RaceConditionExample3 {

    public static void main(String[] args) {
        Map<String,String> sharedMap=new ConcurrentHashMap<>();

        Thread t1=new Thread(getRunnable(sharedMap));
        Thread t2=new Thread(getRunnable(sharedMap));

        t1.start();
        t2.start();
    }

    private static Runnable getRunnable(Map<String, String> sharedMap) {
        return ()->{
          for(int i=0;i<1_000_000;i++){
              synchronized (sharedMap){
                  if(sharedMap.containsKey("key")){
                      System.out.println("key is removing");
                      String result=sharedMap.remove("key");
                      System.out.println("removed key result: "+result);
                      if(result==null){
                          System.out.println("Iteration "+i+" Value for key null");
                      }
              }else{
                      sharedMap.put("key","value");
                      System.out.println("putted key");
                  }

              }
          }
        };
    }
}
