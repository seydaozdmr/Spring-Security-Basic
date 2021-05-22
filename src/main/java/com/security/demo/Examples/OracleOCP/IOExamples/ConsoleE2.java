package com.security.demo.Examples.OracleOCP.IOExamples;

import java.io.Console;

public class ConsoleE2 {
    public static void main(String[] args) {
        Console console=System.console();
        String color=console.readLine("Renk yaz: ");
        console.format("Yazdığınız renk : %s ",color);
    }
}
