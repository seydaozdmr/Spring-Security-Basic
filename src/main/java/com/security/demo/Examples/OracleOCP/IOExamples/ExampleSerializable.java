package com.security.demo.Examples.OracleOCP.IOExamples;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExampleSerializable {
    public static void main(String[] args) throws IOException , ClassNotFoundException {
        Student s1=new Student("Hasan","Yılmaz", LocalDate.of(2021,05,13));
        Student s2=new Student("Mustafa","Durmuş",LocalDate.of(2021,05,12));
        Student s3=new Student("Hatice","Norcu",LocalDate.of(2021,05,14));
        Student s4=new Student("Seyda","Özdemir",LocalDate.of(2021,06,11));

        List<Student> ogrenciler=new ArrayList<>();
        ogrenciler.add(s1);
        ogrenciler.add(s2);
        ogrenciler.add(s3);
        ogrenciler.add(s4);

        File parent=new File("C:\\");
        File myFile=new File(parent,"\\test\\ogrenciler.txt");

//        try(ObjectOutputStream stream=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(myFile)))){
//            for(Student student:ogrenciler){
//                stream.writeObject(student);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        try(ObjectInputStream stream=new ObjectInputStream(new BufferedInputStream(new FileInputStream(myFile)))){
//            boolean eof=true;
            while(true){
                Object elem=stream.readObject();
                if(elem instanceof Student){
                    System.out.println(elem);
                }
            }
        }catch (EOFException e){

        }
    }
}
