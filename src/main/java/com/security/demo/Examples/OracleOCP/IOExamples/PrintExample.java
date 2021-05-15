package com.security.demo.Examples.OracleOCP.IOExamples;

import java.io.*;

public class PrintExample {
    public static void main(String[] args) {
        File file = new File("C:\\test\\test3.log");
        try(PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(file)))){
            writer.print("Bugün hava durumu : ");
            writer.println("Güneşli");
            writer.print("Derece : ");
            writer.print("1/3.0");
            writer.println(" C");
            writer.format("Bu yıl %d metre kareye %5.2f yağış düşmüştür",2021,10.5);
            writer.println();
            writer.printf("Geçen yıla göre %s daha fazla yağış düşmüştür",1.2);
        }catch (IOException e){
            e.printStackTrace();
        }
        //Reading through FileReader and BufferedReader
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String result;
            while((result=reader.readLine())!=null){
                //result.append(reader.readLine());
                System.out.println(result);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
