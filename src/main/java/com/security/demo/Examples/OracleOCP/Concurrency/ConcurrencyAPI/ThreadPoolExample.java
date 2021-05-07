package com.security.demo.Examples.OracleOCP.Concurrency.ConcurrencyAPI;



public class ThreadPoolExample  {
    public static void main(String[] args) throws Exception {
        ThreadPool threadPool=new ThreadPool(3,10);

        for(int i=0;i<30;i++){
            int taskNo=i;
            Thread.sleep(100);
            threadPool.execute(()->{
                String message=Thread.currentThread().getName() + " : Task "+taskNo;
                if(message!=null){
                    System.out.println(message);
                }

            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
