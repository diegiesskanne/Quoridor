package com.company;

import javax.swing.*;

public class Main {

    static PlaygroundGUI gui;

    public static void main(String[] args) {
	// write your code here
        //int playercount = Integer.parseInt(args[0]);

        // start game

        gui = new PlaygroundGUI();
        PlayerActions.Button1Handler bu1handler = new PlayerActions.Button1Handler();
        PlayerActions.Button2Handler bu2handler = new PlayerActions.Button2Handler();
        PlayerActions.Button3Handler bu3handler = new PlayerActions.Button3Handler();

        JButton button1 = new JButton("Place Barrier");
        button1.setBounds(15, 15, 200, 90);
        JButton button2 = new JButton("Finished");
        button2.setBounds(230, 15, 200, 90);
        JButton button3 = new JButton("Move Player");
        button3.setBounds(445, 15, 200, 90);

        gui.add(button1);
        gui.add(button2);
        gui.add(button3);

        button1.addActionListener(bu1handler);
        button2.addActionListener(bu2handler);
        button3.addActionListener(bu3handler);


    }

}
