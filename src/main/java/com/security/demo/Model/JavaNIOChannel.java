package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.imageio.stream.FileCacheImageInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;

@Component
public class JavaNIOChannel implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        try {
            //for writing and reading txt file throw FileInputStream byte type.
//            FileInputStream file=new FileInputStream("data.txt");
//            FileChannel channel=file.getChannel();
//            Path dataPath= FileSystems.getDefault().getPath("data.txt");
//            StringBuilder stringBuilder=new StringBuilder();
//            stringBuilder.append("\nLine 9");
//            stringBuilder.append("\nLine 10");
//            stringBuilder.append("\nLine 11");
//            Files.write(dataPath,stringBuilder.toString().getBytes("UTF-8"), StandardOpenOption.APPEND);
//            List<String> lines= Files.readAllLines(dataPath);
//            for(String line:lines){
//                System.out.println(line);
//            }

            //writing binary files .dat
            FileOutputStream binFile=new FileOutputStream("data.dat");
            FileChannel binChannel=binFile.getChannel();
            byte[] outputBytes="Hello World!".getBytes();
            ByteBuffer buffer=ByteBuffer.wrap(outputBytes);
            int numBytes=binChannel.write(buffer);

            System.out.println("numBytes written was: "+numBytes);

            ByteBuffer intBuffer=ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            numBytes=binChannel.write(intBuffer);
            System.out.println("intBuffer bytes: "+numBytes);

            intBuffer.flip();
            intBuffer.putInt(-25245);
            intBuffer.flip();
            numBytes=binChannel.write(intBuffer);
            System.out.println("intBuffer bytes: "+numBytes);

            //reading binary data from data.dat for this purpose we will use RandomAccessFile which is part of java.io library
//            RandomAccessFile ra=new RandomAccessFile("data.dat","rwd");
//            byte[] ba=new byte[outputBytes.length];
//            ra.read(ba);
//            System.out.println(new String(ba));
//            long int1=ra.readInt();
//            long int2=ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);

            //reading binary data by channel

            RandomAccessFile ra=new RandomAccessFile("data.dat","rwd");
            FileChannel channel=ra.getChannel();


            outputBytes[0]='a';
            buffer.flip();
            long numBytesRead=channel.read(buffer);
            System.out.println("outputBytes "+new String(outputBytes));
            if(buffer.hasArray()){
                System.out.println("byte buffer : "+new String(buffer.array()));
            }
            //sayıları okumak için relative read örneği
            intBuffer.flip();
            numBytesRead=channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            intBuffer.flip();
            numBytesRead=channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
            channel.close();
            ra.close();
            //absolute read:
            //intBuffer.flip();
            //numBytesRead=channel.read(intBuffer);
            //System.out.println(intBuffer.getInt(0));
            //intBuffer.flip();
            //numBytesRead=channel.read(intBuffer);
            //System.out.println(intBuffer.getInt(0));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
