package main.java.org.anno.perudo;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {
    setTitle("Testing");

    setSize(500, 500);


    Dice d = new Dice();
    int val = d.getValue();


    System.out.println(val);


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLocationRelativeTo(null);
    setVisible(true);
    }
}
