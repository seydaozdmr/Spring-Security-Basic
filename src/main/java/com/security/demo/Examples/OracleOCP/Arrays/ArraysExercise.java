package com.security.demo.Examples.OracleOCP.Arrays;

import java.util.Arrays;

public class ArraysExercise {
    public static void main(String[] args) {
        String [] names=new String[4];
        names[0]="Jane";
        names[1]="George";
        names[2]="Tom";
        names[3]="Frank";

        Arrays.sort(names,new LengthCompare());
        for(String name:names){
            System.out.println(name);
        }

        char [][] chars={{'1','2','3'},{'4','5','6'},{'7','8','9'}};

        for(char[] row:chars) {
            for(char c:row)
            {
                System.out.print(c+" ");
            }
            System.out.println();
        }


    }
}
