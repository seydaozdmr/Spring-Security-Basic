package com.security.demo.Model;



import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//Not:If you don't need to implement all four of the FileVisitor methods,
// instead of implementing the FileVisitor interface,
// you can extend the SimpleFileVisitor class.
public class FileVisitorSimple extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isSymbolicLink()){
            System.out.format("Symbolic Link: %s ",file);
        }else if(attrs.isRegularFile()){
            System.out.format("Regular file: %s",file);
        }else{
            System.out.format("other : %s ",file);
        }
        System.out.println("(" +attrs.size() +"bytes)");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.format("Directory : %s%n",dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
}
