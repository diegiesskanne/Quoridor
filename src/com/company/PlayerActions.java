package com.company;

import javax.management.monitor.GaugeMonitor;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayerActions {

    static int mouseposition_x = -100;
        static int mouseposition_y = -100;
        static int mousedrag_x = -100;
        static int mousedrag_y = -100;
        static ArrayList<int[]> dragarraylist = new ArrayList<int[]>();
        static boolean dragactive = false;
        static boolean listening = false;
        static Move move = new Move();
        static Click click = new Click();

        public int getmouseposition_x(){
            return mouseposition_x;
        }
        public int getmouseposition_y(){
            return mouseposition_y;
        }

        public static class Move implements MouseMotionListener{

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                if(dragactive) {
                    mousedrag_x = mouseEvent.getX();
                    mousedrag_y = mouseEvent.getY();
                    int[] tmp = {mousedrag_x, mousedrag_y};
                    dragarraylist.add(tmp);
                }
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                mouseposition_x = mouseEvent.getX();
                mouseposition_y = mouseEvent.getY();
            }
        }

        public static class Click implements MouseListener{

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                // when pressed the button
                //System.out.println("mouse was clicked");
                PlaygroundGUI.ground.repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                //Main.gui.startlistening();
                dragactive = false;
                Main.gui.create_border();

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        }

        public static class Button1Handler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Button1 pressed");
                PlaygroundGUI.ground.addMouseMotionListener(move);
                PlaygroundGUI.ground.addMouseListener(click);
                dragactive = true;
            }
        }
        public static class Button2Handler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Button2 pressed");
                dragarraylist.clear();
                PlaygroundGUI.ground.removeKeyBindings();
                PlaygroundGUI.ground.removeMouseMotionListener(move);
                PlaygroundGUI.ground.removeMouseListener(click);
                GameMaster.gamestate = !GameMaster.gamestate;
                //PlaygroundGUI.ground.repaint();
            }
        }

        public static class Button3Handler implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Button3 pressed");
                PlaygroundGUI.ground.addKeyBindings();

            }
        }
        static class MoveLeftAction extends AbstractAction {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!GameMaster.gamestate) {
                    Ground.player1.move_left();
                } else {
                    Ground.player2.move_left();
                }
                System.out.println("Player moved left");
            }
        }

        static class MoveRightAction extends AbstractAction {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!GameMaster.gamestate) {
                    Ground.player1.move_right();
                } else {
                    Ground.player2.move_right();
                }
                System.out.println("Player moved right");
            }
        }
        static class MoveUpAction extends AbstractAction {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!GameMaster.gamestate) {
                    Ground.player1.move_up();
                }else {
                    Ground.player2.move_up();
                }
                System.out.println("Player moved up");
            }
        }
        static class MoveDownAction extends AbstractAction {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!GameMaster.gamestate) {
                    Ground.player1.move_down();
                }else {
                    Ground.player2.move_down();
                }
                System.out.println("Player moved down");
            }
        }
}
