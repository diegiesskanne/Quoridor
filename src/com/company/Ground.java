package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Ground extends JPanel {

    int spacing = 15;
    static Player player1;
    static Player player2;

    static InputMap im;
    static ActionMap am;
    static PlayerActions.MoveLeftAction leftAction;
    static PlayerActions.MoveRightAction rightAction;
    static PlayerActions.MoveUpAction upAction;
    static PlayerActions.MoveDownAction downAction;

    public Ground() {
        player1 = new Player(spacing + 4 * 100 + 10, spacing + 100 + 10, 50, 50, 1);
        player2 = new Player(spacing + 4 * 100 + 10, spacing + 100 + 8 * 100 + 10, 50, 50, 2);

        im = this.getInputMap(WHEN_IN_FOCUSED_WINDOW);
        am = this.getActionMap();
        leftAction = new PlayerActions.MoveLeftAction();
        rightAction = new PlayerActions.MoveRightAction();
        upAction = new PlayerActions.MoveUpAction();
        downAction = new PlayerActions.MoveDownAction();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 915, 1015);
        g.setColor(Color.CYAN);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                g.setColor(Color.CYAN);
                g.fillRect(spacing + i*100, spacing + 100 + j*100, 100-2*spacing, 100-2*spacing);
            }
        }

        player1.draw_player(g);
        player2.draw_player(g);

        if(!PlaygroundGUI.horizontal_border_list.isEmpty() || !PlaygroundGUI.vertical_border_list.isEmpty()) {
            for (int e = 0; e < PlaygroundGUI.horizontal_border_list.size(); e++) {
                g.setColor(Color.BLACK);
                int k = PlaygroundGUI.horizontal_border_list.get(e);
                int l = k / 10;
                int n = k % 10;
                g.fillRect((l * 100) + 15, (n * 100) + 95, 170, 10);
            }
            for (int f = 0; f < PlaygroundGUI.vertical_border_list.size(); f++) {
                g.setColor(Color.BLACK);
                int k = PlaygroundGUI.vertical_border_list.get(f);
                int l = k / 10;
                int n = k % 10;
                g.fillRect((n * 100) - 5, ((l+1) * 100) + 15, 10, 170);
            }
        }
        repaint();
    }
    public void addKeyBindings(){
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
                "moveleft");
        am.put("moveleft",
                leftAction);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),
                "moveright");
        am.put("moveright",
                rightAction);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
                "moveup");
        am.put("moveup",
                upAction);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
                "movedown");
        am.put("movedown",
                downAction);
    }
    public void removeKeyBindings(){
        im.remove(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0));
        im.remove(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));
        im.remove(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0));
        im.remove(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
    }
}
