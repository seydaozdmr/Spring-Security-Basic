package com.security.demo.Threads;

import java.util.Random;

public class MessageSample_6 {
    public static void main(String[] args) {
        Message message=new Message();
        //Thread'lerden biri yazarken diğeri okuyor.
        //Sırasıyla çalışıyorlar.
        (new Thread(new Write(message))).start();
        (new Thread(new Read(message))).start();
    }
}

class Message{
    private String message;
    private boolean empty=true;

    public synchronized String read(){
        while(empty){
            //Okumak için yazma sırasının geçmesini bekliyor. bekliyor.
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        //yazdıktan sonra false olan empty'den dolayı yukarıdaki döngü çalışmıyor ve empty true yapılıp mesaj okunuyor.
        empty=true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        //ilk başta empty true oluyor dolaysıyla bu döngü ilk yazılan için çalışmıyor.
        while (!empty){
            //İlk başta burası yazıyor ve okuma sırasını bekliyor.
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        //true olan empty false olarak değiştiriliyor ve okuma sırasına geçiyor..
        empty=false;
        this.message=message;
        notifyAll();
    }
}

class Write implements Runnable{
    private Message message;

    public Write (Message message){
        this.message=message;
    }

    @Override
    public void run() {
        //Buradaki messages array'inden sırasıyla alıp Message sınıfından türetilen message nesnesinde bulunan
        //message String propery'sine yazıyor.
        String messages[] = {
          "Sen almazsan ben almazsam bu ekonomi nasıl canlanacak.",
          "Patates çuvalları olmasa nasıl besleneceğiz.",
          "Çok büyük bir kazan olacak hepsini atacaksın."
        };

        Random random=new Random();

        for(int i=0;i< messages.length;i++){
            message.write(messages[i]);
            try{
                //Yazdıktan sonra 0 ile 2 saniye arasında bir süre bekliyor.
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        message.write("Finished");
    }
}

class Read implements Runnable{
    private Message message;

    public Read(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random=new Random();
        for(String latesMessage=message.read(); !latesMessage.equals("Finished"); latesMessage = message.read()){
            System.out.println(latesMessage);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
