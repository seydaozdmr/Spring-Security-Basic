package com.security.demo.Examples.OracleOCP.IOExamples;

import java.io.Console;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console=System.console();

        if(console==null){
            throw new RuntimeException("Console not available!");
        }else{
            console.writer().println("Wellcome to zoo");
            console.format("It has ½d animals and employs %d people",391,25);
            console.writer().println();
            console.printf("The zoo spans %5.1f acres",128.9);
        }
    }
}
