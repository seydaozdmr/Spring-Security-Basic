package com.security.demo.Threads;

import org.hibernate.validator.internal.constraintvalidators.hv.pl.PolishNumberValidator;
import org.springframework.security.core.parameters.P;

public class SayHallo {

    public static void main(String[] args) {
        PolitePerson p1=new PolitePerson("hasan");
        PolitePerson p2=new PolitePerson("mehmet");
        new Thread(new Runnable() {
            @Override
            public void run() {
                p1.sayHallo(p2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                p2.sayHallo(p1);
            }
        }).start();


    }

    static class PolitePerson{
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHallo(PolitePerson person){
            System.out.format("%s: %s "+ "has said hello to me %n",this.name,person.getName());
            synchronized (person){
                person.sayHalloBack(this);
            }

        }

        public synchronized void sayHalloBack(PolitePerson person){
            System.out.format("%s: %s "+"has said hallo back to me! %n",this.name,person.getName());
        }
    }
}
