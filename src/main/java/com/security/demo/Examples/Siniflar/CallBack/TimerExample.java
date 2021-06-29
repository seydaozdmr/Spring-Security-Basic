package com.security.demo.Examples.Siniflar.CallBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerExample {

    public static void main(String[] args) throws InterruptedException {
        Timer t1=new Timer(1_000,new TimePrinter());
        t1.start();

        //Thread.sleep(1000);

        JOptionPane.showMessageDialog(null,"Quit Program");
        System.exit(0);

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

