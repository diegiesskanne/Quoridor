package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    static PlaygroundGUI gui;
    static  JLabel barriers1;
    static  JLabel barriers2;
    static PlayerActions.Button1Handler bu1handler;
    static PlayerActions.Button2Handler bu2handler;
    static PlayerActions.Button3Handler bu3handler;

    public static void main(String[] args) {

        //int playercount = Integer.parseInt(args[0]);

        // start game
        gui = new PlaygroundGUI();
        bu1handler = new PlayerActions.Button1Handler();
        bu2handler = new PlayerActions.Button2Handler();
        bu3handler = new PlayerActions.Button3Handler();

        JButton button1 = new JButton("Place Barrier");
        button1.setBounds(15, 15, 100, 90);
        JButton button2 = new JButton("Finished");
        button2.setBounds(130, 15, 100, 90);
        JButton button3 = new JButton("Move Player");
        button3.setBounds(245, 15, 100, 90);
        barriers1 = new JLabel(String.valueOf(Ground.player1.barriersremaining));
        barriers1.setBounds(360,15,100,90);
        barriers1.setOpaque(true);
        barriers1.setBackground(Color.CYAN);
        barriers2 = new JLabel(String.valueOf(Ground.player2.barriersremaining));
        barriers1.setBounds(475,15,100,90);
        barriers2.setOpaque(true);
        barriers2.setBackground(Color.CYAN);

//        button1.setVisible(true);
//        button2.setVisible(true);
//        button3.setVisible(true);
//        barriers1.setVisible(true);
//        barriers2.setVisible(true);

        gui.add(button1);
        gui.add(button2);
        gui.add(button3);
        gui.add(barriers1);
        gui.add(barriers2);
        //gui.setVisible();

        button1.addActionListener(bu1handler);
        button2.addActionListener(bu2handler);
        button3.addActionListener(bu3handler);

    }

}
