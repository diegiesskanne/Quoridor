package com.company;

import javax.swing.*;

public class GameMaster {
    static boolean gamestate;
    static boolean gamefinished;

    public GameMaster(){
        gamestate = false;
        gamefinished = false;
    }

    public void checkforVictory(){
        if(Ground.player1.yPos > 900) {
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "Red won :)", "Game over!", JOptionPane.INFORMATION_MESSAGE);
        }
        if(Ground.player2.yPos < 200){
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "Blue won :)", "Game over!", JOptionPane.INFORMATION_MESSAGE);
        }
        gamefinished = true;
    }

}
