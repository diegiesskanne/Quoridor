package com.company;

import javax.swing.*;

public class GameMaster {
    static boolean gamestate;
    static boolean gamefinished;
    static int save_x = 0;
    static int save_y = 0;
    static int done = -1;
    static int fake = -1;

    public GameMaster(){
        //players turn
        gamestate = false;
        gamefinished = false;
    }

    public void checkforVictory(){
        if(Ground.player1.yPos > 900) {
            if(fake != 1) {
                JOptionPane.showMessageDialog(PlaygroundGUI.ground, "Red won :)", "Game over!", JOptionPane.INFORMATION_MESSAGE);
            }
            gamefinished = true;
        }
        if(Ground.player2.yPos < 200){
            if(fake != 1) {
                JOptionPane.showMessageDialog(PlaygroundGUI.ground, "Blue won :)", "Game over!", JOptionPane.INFORMATION_MESSAGE);
            }
            gamefinished = true;
        }
    }

    public void rekhelp(int last){

        // 0 = up
        // 1 = left
        // 2 = down
        // 3 = right
        fake = 1;

        if (last == -1) {
            save_x = Ground.player2.xPos;
            save_y = Ground.player2.yPos;
        }

        if (Ground.player2.move_up() && last != 2) {
            System.out.println("Check moved up!");
            if (gamefinished) {
                Ground.player2.xPos = save_x;
                Ground.player2.yPos = save_y;
                done = 1;
                gamefinished = false;
                System.out.println("Hello!");
                return;
            }
            rekhelp(0);
        } else if (Ground.player2.move_left() && last != 3) {
            System.out.println("Check moved left!");
            rekhelp(1);
        } else if (Ground.player2.move_down() && last != 0) {
            System.out.println("Check moved down!");
            rekhelp(2);
        } else if (Ground.player2.move_right() && last != 1) {
            System.out.println("Check moved right!");
            rekhelp(3);
        } else {
            System.out.println("UNSOLVABLE!!!!!!!!");
            done = 0;
        }
    }

    public boolean checkforClosed(int inp) {

        rekhelp(inp);
        while(true){
            if (done == 0){
                return false;
            }
            if (done == 1){
                return true;
            }
        }
    }

}
