package com.security.demo.Examples.Siniflar.CallBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerExample {

    public static void main(String[] args) throws InterruptedException {
        Timer t1=new Timer(1_000,new TimePrinter());
        //t1.start();

        //Thread.sleep(1000);

//        JOptionPane.showMessageDialog(null,"Quit Program");
//        System.exit(0);


        //anonymous class
        Timer t2=new Timer(2_000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Merhaba dünya");
                Toolkit.getDefaultToolkit().beep();
            }
        });
        t2.start();
        //Thread.sleep(10000);

    }
}
class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Date now=new Date();
        System.out.println("At the tone, the time is "+ now);
        Toolkit.getDefaultToolkit().beep();
    }
}

