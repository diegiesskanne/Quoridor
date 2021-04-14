package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class PlaygroundGUI extends JFrame {

    static ArrayList<Integer> vertical_border_list;
    static ArrayList<Integer> horizontal_border_list;
    static Ground ground;
    static GameMaster master;

    public PlaygroundGUI(){
        this.setTitle("Quoridor");
        this.setSize(916, 1040);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setVisible(true);
        this.setResizable(false);
        ground = new Ground();
        master = new GameMaster();
        this.setContentPane(ground);
        vertical_border_list = new ArrayList<Integer>();
        horizontal_border_list = new ArrayList<Integer>();
        this.setVisible(true);

    }


    public void create_border(){
        if(!PlayerActions.dragarraylist.isEmpty()) {
            int[] first = PlayerActions.dragarraylist.get(0);
            int tm = PlayerActions.dragarraylist.size();
            int[] last = PlayerActions.dragarraylist.get(tm - 1);
            // waagrecht dann senkrecht
            if ((Math.abs(first[1] - last[1]) < 15) && (Math.abs(first[0] - last[0]) > 130)) {
                int a = first[0] + 55;
                int b = a / 100;
                int e = first[1] - 115;
                int f = (e / 100) + 1;
                int k = Integer.parseInt(String.valueOf(b) + String.valueOf(f));
                int q = b+1;
                int t = b-1;
                int v = f-1;
                int o = Integer.parseInt(String.valueOf(v) + String.valueOf(q));
                int s = Integer.parseInt(String.valueOf(q) + String.valueOf(f));
                int u = Integer.parseInt(String.valueOf(t) + String.valueOf(f));
                if(horizontal_border_list.contains(k) || horizontal_border_list.contains(s) || horizontal_border_list.contains(u) || vertical_border_list.contains(o)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "There is already a barrier!", "Cannot place barrier here!", JOptionPane.ERROR_MESSAGE);
                    PlayerActions.dragarraylist.clear();
                    return;
                }else {
                    horizontal_border_list.add(k);
                    if(!PlaygroundGUI.master.checkforClosed(-1)) {
                        JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You're cutting the last possible path!", "Cannot place barrier here!", JOptionPane.ERROR_MESSAGE);
                        PlayerActions.dragarraylist.clear();
                        horizontal_border_list.remove(k);
                        return;
                    }
                    if(!GameMaster.gamestate){
                        Ground.player1.reduceBarrier();
                        Main.barriers1.setText(String.valueOf(Ground.player1.barriersremaining));
                    }else{
                        Ground.player2.reduceBarrier();
                        Main.barriers2.setText(String.valueOf(Ground.player2.barriersremaining));
                    }
                }
                //System.out.println("b ist " + Integer.toString(b));
                //System.out.println("f ist " + Integer.toString(f));
            } else if ((Math.abs(first[1] - last[1]) > 130) && (Math.abs(first[0] - last[0]) < 15)) {
                int a = first[1] - 30;
                int b = a / 100;
                int e = first[0] - 15;
                int f = (e / 100) + 1;
                int k = Integer.parseInt(String.valueOf(b) + String.valueOf(f));
                int q = b+1;
                int t = b-1;
                int v = f-1;
                int o = Integer.parseInt(String.valueOf(v) + String.valueOf(q));
                int s = Integer.parseInt(String.valueOf(q) + String.valueOf(f));
                int u = Integer.parseInt(String.valueOf(t) + String.valueOf(f));
                if(vertical_border_list.contains(k) || vertical_border_list.contains(s)|| vertical_border_list.contains(u) || horizontal_border_list.contains(o)){
                    JOptionPane.showMessageDialog(PlaygroundGUI.ground, "There is already a barrier!", "Cannot place barrier here!", JOptionPane.ERROR_MESSAGE);
                    PlayerActions.dragarraylist.clear();
                    return;
                }else {
                    vertical_border_list.add(k);
                    if(!PlaygroundGUI.master.checkforClosed(-1)) {
                        JOptionPane.showMessageDialog(PlaygroundGUI.ground, "You're cutting the last possible path!", "Cannot place barrier here!", JOptionPane.ERROR_MESSAGE);
                        PlayerActions.dragarraylist.clear();
                        vertical_border_list.remove(k);
                        return;
                    }
                    if(!GameMaster.gamestate){
                        Ground.player1.reduceBarrier();
                        Main.barriers1.setText(String.valueOf(Ground.player1.barriersremaining));
                    }else{
                        Ground.player2.reduceBarrier();
                        Main.barriers2.setText(String.valueOf(Ground.player2.barriersremaining));
                    }
                }
                //System.out.println("b ist " + Integer.toString(b));
                //System.out.println("f ist " + Integer.toString(f));
            }
            first[0] = 0;
            first[1] = 0;
            last[0] = 0;
            last[1] = 0;
            System.out.println(horizontal_border_list);
            System.out.println(vertical_border_list);
        }
    }
}


