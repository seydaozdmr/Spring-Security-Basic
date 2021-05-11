package com.security.demo.Examples.OracleOCP.Concurrency.ParallelStreams;

import java.util.stream.Stream;

public class Example2 {

    public static void main(String[] args) {
        //Performing Order-Based Tasks
        Stream<Integer> s1=Stream.of(1,2,3,4,5,6,7);
        System.out.println(s1.findAny().get());

        Stream<Integer> s2=Stream.of(1,2,3,4,5,6,7);
        System.out.println(s2.parallel()
                .peek(p-> System.out.println(Thread.currentThread().getName()+" - "+p))
                .findAny().get());

        //Combining Results with reduce()
        Stream<Character> s3=Stream.of('k','u','r','t');
        System.out.println(s3.parallel().reduce("",(s5,c)->s5+c,(s6,s7)->s6+s7));

        //it is recommended that use the three-argument version of reduce:
        Stream<Integer> s4=Stream.of(1,2,3,4,5,6);
        System.out.println(s4.parallel().reduce(0,(a,b)->a-b));

        Stream<Character> s5=Stream.of('k','u','z','u');
        System.out.println(s5.parallel().reduce("X",(s6,v)->s6+v,(s7,s8)->s7+s8));

    }
}
