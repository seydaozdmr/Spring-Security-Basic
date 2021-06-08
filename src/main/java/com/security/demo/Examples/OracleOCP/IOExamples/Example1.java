package com.security.demo.Examples.OracleOCP.IOExamples;

import java.io.File;

public class Example1 {
    public static void main(String[] args) {
        //windows olduğu için dosya yolunu belirtmek için \\ çift bölü kullandım
        File file=new File("\\test.txt");
        System.out.println(file.exists()); //true or false

        File file1=new File("C:\\","\\test\\test.txt");
        System.out.println(file1.exists());

        File parent=new File("C:\\");
        File file2=new File(parent,"\\test\\test2.txt");
        System.out.println(file2.exists());

        //getting absolute path:
        System.out.println("path :"+file2.getAbsolutePath());
        System.out.println(file2);
        //getting parent
        System.out.println("path2 :"+file2.getParent());
        File newFile=new File(file2.getParent());
        System.out.println("new File :"+newFile);

        //check if is directory or file
        System.out.println(file2.isFile());
        System.out.println(parent.isDirectory()); // --  c:\\
        //number of length :
        System.out.println(file2.length()); //only writes test in it

        File directory=file2.getParentFile();
        System.out.println(directory.getAbsolutePath());
        //showing files in directory
        for(File files:directory.listFiles()){
            System.out.println(files.getName());
        }

        for(String i:file2.list()){
            System.out.println(i);
        }
        //parent directory
        System.out.println("********C:**************");
//        for(File files:parent.listFiles()){
//            if(files.isFile()){
//                System.out.println(files.getName());
//            }else if(files.isDirectory() || files.listFiles().length>0){
//                for(File elem:files.listFiles()){
//                    System.out.println(elem.getName());
//                }
//            }
//        }

    }
}
