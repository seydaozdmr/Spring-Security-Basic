package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

@Component
public class JavaNIOChannelAbsoluteRelative implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

//        try (//writing binary files .dat
//            FileOutputStream binFile=new FileOutputStream("data2.dat");
//            FileChannel binChannel=binFile.getChannel()){
//            ByteBuffer buffer=ByteBuffer.allocate(100);
//            byte[] outputBytes="Merhaba Dünya!!".getBytes();
//            buffer.put(outputBytes);
//            long int1Pos=outputBytes.length;
//            buffer.putInt(1753);
//            long int2Pos=int1Pos+Integer.BYTES;
//            buffer.putInt(-15767);
//            byte [] outputByte2="Tanıştığıma memnun oldum.".getBytes();
//            buffer.put(outputByte2);
//            long int3Pos=int2Pos+Integer.BYTES+outputByte2.length;
//            buffer.putInt(5500);
//            buffer.flip();
//            binChannel.write(buffer);
//
//            //bu kısım relative
////            byte[] outputBytes="Merhaba Dünya!".getBytes();
////            buffer.put(outputBytes);
////            buffer.putInt(265);
////            buffer.putInt(-86464);
////            byte[] outputByte2="Tanıştığımıza memnun oldum.".getBytes();
////            buffer.put(outputByte2);
////            buffer.putInt(5434);
////            //eğer flip kullanmazsak buffer pozisyonu channel.write'ın sonuna gider.
////            System.out.println("before flip: "+binChannel.position());
////            buffer.flip();
////            binChannel.write(buffer); //dosyaya yazıyoruz
////            System.out.println("flip then: "+binChannel.position());
//
//            //reading data reverse
//            RandomAccessFile ra=new RandomAccessFile("data2.dat","rwd");
//            FileChannel channel = ra.getChannel();
//
//            ByteBuffer readBuffer=ByteBuffer.allocate(Integer.BYTES);
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("int 3 : "+readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("int 2: "+readBuffer.getInt());
//
//            readBuffer.flip();
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("int 1: "+readBuffer.getInt());
//
//            //coping file
//            RandomAccessFile copyFile=new RandomAccessFile("datacopy.dat","rwd");
//            FileChannel copyChannel=copyFile.getChannel();
//            //bu şekilde bırakırsak channel.position eklemeden kopyama işlemini data2.dat'ın açık olan channel'den relative pozisyonundan itibaren başlayacak ama
//            //biz absolute kesin pozisyondan başlamasını istiyoruz. bunun için bu yazının altına channel.position(0) eklemek gerekiyor.
//            channel.position(0);
//            long numTransferred=copyChannel.transferFrom(channel,0,channel.size());
//            //başka bir transfer yöntemi:
//            //long numTransferred=channel.transferTo(0,channel.size(),copyChannel);
//            System.out.println("Num transferred: "+numTransferred);
//
//            channel.close();
//            ra.close();
//            copyChannel.close();
//
//
//
//            //reading data
////            RandomAccessFile ra=new RandomAccessFile("data2.dat","rwd");
////            FileChannel channel=ra.getChannel();
////
////            ByteBuffer readBuffer=ByteBuffer.allocate(100);
////            channel.read(readBuffer);
////            readBuffer.flip();
////            byte[] inputString=new byte[outputBytes.length];
////            readBuffer.get(inputString);
////            System.out.println("input string: "+new String(inputString));
////            System.out.println("int1 = "+readBuffer.getInt());
////            System.out.println("int2 = "+readBuffer.getInt());
////            byte[] inputString2=new byte[outputByte2.length];
////            readBuffer.get(inputString2);
////            System.out.println("input String 2 = "+new String(inputString2));
////            System.out.println("int3 = "+readBuffer.getInt());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
