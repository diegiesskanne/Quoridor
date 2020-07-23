package com.company;

import javax.swing.*;
import java.awt.*;
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
                //int c = a + 100;
                //int d = c / 100;
                int e = first[1] - 115;
                int f = (e / 100) + 1;
                int k = Integer.parseInt(String.valueOf(b) + String.valueOf(f));
                int p = f-1;
                int q = b+1;
                int o = Integer.parseInt(String.valueOf(p) + String.valueOf(q));
                //TODO fix barrier placement
                if(horizontal_border_list.contains(k) || horizontal_border_list.contains(o) || vertical_border_list.contains(k) || vertical_border_list.contains(o)){
                    System.out.println("Cannot place Barrier there");
                }else {
                    horizontal_border_list.add(k);
                }
                System.out.println("b ist " + Integer.toString(b));
                System.out.println("f ist " + Integer.toString(f));
            } else if ((Math.abs(first[1] - last[1]) > 130) && (Math.abs(first[0] - last[0]) < 15)) {
                int a = first[1] - 30;
                int b = a / 100;
                //int c = a + 100;
                //int d = c / 100;
                int e = first[0] - 15;
                int f = (e / 100) + 1;
                int k = Integer.parseInt(String.valueOf(b) + String.valueOf(f));
                //TODO fix barrier placement
                int p = f-1;
                int q = b+1;
                int o = Integer.parseInt(String.valueOf(p) + String.valueOf(q));
                if(vertical_border_list.contains(k) || vertical_border_list.contains(o) || horizontal_border_list.contains(k) || horizontal_border_list.contains(o)){
                    System.out.println("Cannot place Barrier there");
                }else {
                    vertical_border_list.add(k);
                }
                System.out.println("b ist " + Integer.toString(b));
                System.out.println("f ist " + Integer.toString(f));
            }
            System.out.println(horizontal_border_list);
            System.out.println(vertical_border_list);
        }
    }
}


