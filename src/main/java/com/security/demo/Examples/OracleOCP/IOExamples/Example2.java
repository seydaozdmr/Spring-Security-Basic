package com.security.demo.Examples.OracleOCP.IOExamples;

import java.io.*;

public class Example2 {
    //reading writing data
    public static void main(String[] args) {
        File parent=new File("C:\\");
        File file=new File(parent,"\\test\\test.txt");
        File file2=new File(parent,"\\test\\test2.txt");

//        try{
//            FileInputStream inputStream=new FileInputStream(file);
//            while(inputStream.read()>0){
//                System.out.println(inputStream.read());
//            }
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //for performance improvements
        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(file))){
            int b;
            while((b=in.read())!=-1){
                char [] c=Character.toChars(b);
                System.out.println(c);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try(BufferedReader reader=new BufferedReader(new FileReader(file2))){
            String result;
            while((result=reader.readLine())!=null){
                //result.append(reader.readLine());
                System.out.println(result);
            }
            //System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
