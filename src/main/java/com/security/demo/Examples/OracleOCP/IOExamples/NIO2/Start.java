package com.security.demo.Examples.OracleOCP.IOExamples.NIO2;


import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Start {
    public static void main(String[] args) {
        Path path = Paths.get("C:\\","\\test\\test.txt");
        System.out.println(path.isAbsolute());
        Path path2=Paths.get("C:", File.separator,"test",File.separator,"test.txt");
        System.out.println(path2.isAbsolute());
        URI uri=null;
        try {
            uri=new URI("file://C:/test/test.txt");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Path uriPath=Paths.get(uri);
        System.out.println(uriPath.isAbsolute());
        Path path4= FileSystems.getDefault().getPath("C:\\","\\test\\test.txt");
        System.out.println(path4.isAbsolute());

        File file=new File("C:\\","\\test\\test.txt");
        Path path5=file.toPath();
        System.out.println(path5.isAbsolute());
        System.out.println(file.getAbsolutePath());

    }
}
