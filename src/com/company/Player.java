package com.company;

import javax.swing.*;
import java.awt.*;

public class Player{

    public Integer xPos;
    public Integer yPos;
    public Integer width;
    public Integer height;
    public Integer playerID;

    public Player(int x, int y, int width, int height, int playerID){
        this.xPos = x;
        this.yPos = y;
        this.width = width;
        this.height = height;
        this.playerID = playerID;
    }

    public Integer getxPos() {
        return xPos;
    }

    public void setxPos(Integer xPos) {
        this.xPos = xPos;
    }

    public Integer getyPos() {
        return yPos;
    }

    public void setyPos(Integer yPos) {
        this.yPos = yPos;
    }

    public Integer getWid() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHei() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
    public void setPlayerID(Integer playerID){
        this.playerID = playerID;
    }
    public Integer getPlayerID() { return playerID; }

    public int convert_to_2digit_v(int x, int y){
        int a = x + 55;
        int b = a / 100;
        int e = y - 115;
        int f = (e / 100) + 1;
        return Integer.parseInt(String.valueOf(f - 1) + String.valueOf(b));
    }
    public int convert_to_2digit_h(int x, int y){
        int a = x + 55;
        int b = a / 100;
        int e = y - 115;
        int f = (e / 100) + 1;
        return Integer.parseInt(String.valueOf(b - 1) + String.valueOf(f));

    }

    public void move_up(){
        boolean skipped = false;
        int tmp_yPos = yPos - 30;
        int double_digit = convert_to_2digit_h(xPos, tmp_yPos);
        if(PlaygroundGUI.horizontal_border_list.contains(double_digit) || PlaygroundGUI.horizontal_border_list.contains(double_digit+10)){
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
        }else {
            yPos = yPos - 100;
        }
        if(playerID == 1){
            if (xPos.equals(Ground.player2.xPos) && yPos.equals(Ground.player2.yPos)){
                int tmpp_yPos = yPos - 30;
                int doublee_digit = convert_to_2digit_h(xPos, tmpp_yPos);
                if(PlaygroundGUI.horizontal_border_list.contains(doublee_digit) || PlaygroundGUI.horizontal_border_list.contains(doublee_digit+10)) {
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    yPos = yPos + 100;
                    skipped = false;
                }else {
                    yPos = yPos - 100;
                    skipped = true;
                }
            }
        }
        if(playerID == 2){
            if(xPos.equals(Ground.player1.xPos) && yPos.equals(Ground.player1.yPos)){
                int tmpp_yPos = yPos - 30;
                int doublee_digit = convert_to_2digit_h(xPos, tmpp_yPos);
                if(PlaygroundGUI.horizontal_border_list.contains(doublee_digit) || PlaygroundGUI.horizontal_border_list.contains(doublee_digit+10)) {
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    yPos = yPos + 100;
                    skipped = false;
                }else {
                    yPos = yPos - 100;
                    skipped = true;
                }
            }
        }
        if(yPos < 100){
            if(skipped){
                yPos = 225;
            }else {
                yPos = 125;
            }
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You were about to move out of the playground, we stopped you there:)", "Passing Playground Borders!", JOptionPane.ERROR_MESSAGE);
        }
        PlaygroundGUI.master.checkforVictory();
    }
    public void move_down(){
        boolean skipped = false;
        int tmp_yPos = yPos + 70;
        int double_digit = convert_to_2digit_h(xPos, tmp_yPos);
        if(PlaygroundGUI.horizontal_border_list.contains(double_digit) || PlaygroundGUI.horizontal_border_list.contains(double_digit+10)){
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
        }else {
            yPos = yPos + 100;
        }
        if(playerID == 1){
            if (xPos.equals(Ground.player2.xPos) && yPos.equals(Ground.player2.yPos)){
                int tmpp_yPos = yPos + 70;
                int doublee_digit = convert_to_2digit_h(xPos, tmpp_yPos);
                if(PlaygroundGUI.horizontal_border_list.contains(doublee_digit) || PlaygroundGUI.horizontal_border_list.contains(doublee_digit+10)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    yPos = yPos - 100;
                    skipped = false;
                }else {
                    yPos = yPos + 100;
                    skipped = true;
                }
            }
        }
        if(playerID == 2){
            if(xPos.equals(Ground.player1.xPos) && yPos.equals(Ground.player1.yPos)){
                int tmpp_yPos = yPos + 70;
                int doublee_digit = convert_to_2digit_h(xPos, tmpp_yPos);
                if(PlaygroundGUI.horizontal_border_list.contains(doublee_digit) || PlaygroundGUI.horizontal_border_list.contains(doublee_digit+10)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    yPos = yPos - 100;
                    skipped = false;
                }else {
                    yPos = yPos + 100;
                    skipped = true;
                }
            }
        }
        if(yPos > 1000){
            if(skipped){
                yPos = yPos - 200;
            }else {
                yPos = yPos - 100;
            }
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You were about to move out of the playground, we stopped you there:)", "Passing Playground Borders!", JOptionPane.ERROR_MESSAGE);
        }
        PlaygroundGUI.master.checkforVictory();
    }
    public void move_left(){
        boolean skipped = false;
        int tmp_xPos = xPos - 30;
        int double_digit = convert_to_2digit_v(tmp_xPos, yPos);
        if(PlaygroundGUI.vertical_border_list.contains(double_digit) || PlaygroundGUI.vertical_border_list.contains(double_digit-10)){
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
        }else {
            xPos = xPos - 100;
        }
        if(playerID == 1){
            if (xPos.equals(Ground.player2.xPos) && yPos.equals(Ground.player2.yPos)){
                int tmpp_xPos = xPos - 30;
                int doublee_digit = convert_to_2digit_v(tmpp_xPos, yPos);
                if(PlaygroundGUI.vertical_border_list.contains(doublee_digit) || PlaygroundGUI.vertical_border_list.contains(doublee_digit-10)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    xPos = xPos + 100;
                    skipped = false;
                }else {
                    xPos = xPos - 100;
                    skipped = true;
                }
            }
        }
        if(playerID == 2){
            if(xPos.equals(Ground.player1.xPos) && yPos.equals(Ground.player1.yPos)){
                int tmpp_xPos = xPos - 30;
                int doublee_digit = convert_to_2digit_v(tmpp_xPos, yPos);
                if(PlaygroundGUI.vertical_border_list.contains(doublee_digit) || PlaygroundGUI.vertical_border_list.contains(doublee_digit-10)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    xPos = xPos + 100;
                    skipped = false;
                }else {
                    xPos = xPos - 100;
                    skipped = true;
                }
            }
        }
        if(xPos < 25){
            if(skipped){
                xPos = 100;
            }else {
                xPos = 25;
            }
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You were about to move out of the playground, we stopped you there:)", "Passing Playground Borders!", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void move_right(){
        boolean skipped = false;
        int tmp_xPos = xPos + 70;
        int double_digit = convert_to_2digit_v(tmp_xPos, yPos);
        if(PlaygroundGUI.vertical_border_list.contains(double_digit) || PlaygroundGUI.vertical_border_list.contains(double_digit-10)){
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
        }else {
            xPos = xPos + 100;
        }
        if(playerID == 1){
            if (xPos.equals(Ground.player2.xPos) && yPos.equals(Ground.player2.yPos)){
                int tmpp_xPos = xPos + 70;
                int doublee_digit = convert_to_2digit_v(tmpp_xPos, yPos);
                if(PlaygroundGUI.vertical_border_list.contains(doublee_digit) || PlaygroundGUI.vertical_border_list.contains(doublee_digit-10)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    xPos = xPos - 100;
                    skipped = false;
                }else {
                    xPos = xPos + 100;
                    skipped = true;
                }
            }
        }
        if(playerID == 2){
            if(xPos.equals(Ground.player1.xPos) && yPos.equals(Ground.player1.yPos)){
                int tmpp_xPos = xPos + 70;
                int doublee_digit = convert_to_2digit_v(tmpp_xPos, yPos);
                if(PlaygroundGUI.vertical_border_list.contains(doublee_digit) || PlaygroundGUI.vertical_border_list.contains(doublee_digit-10)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You shall not pass!", "There is a barrier!", JOptionPane.ERROR_MESSAGE);
                    xPos = xPos - 100;
                    skipped = false;
                }else {
                    xPos = xPos + 100;
                    skipped = true;
                }
            }
        }
        if(xPos > 825){
            if(skipped){
                xPos = 725;
            }else {
                xPos = 825;
            }
            JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You were about to move out of the playground, we stopped you there:)", "Passing Playground Borders!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void draw_player(Graphics g){
        if(playerID == 1) {
            g.setColor(Color.RED);
            g.fillOval(xPos, yPos, width, height);
        }else if(playerID == 2){
            g.setColor(Color.BLUE);
            g.fillOval(xPos, yPos, width, height);
        }
    }
}

