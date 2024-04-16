package com.mygdx.game;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI
{
    public static int SCR_WIDTH;
    public static int SCR_HEIGHT;
    public static void createGUI()
    {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(SCR_WIDTH, SCR_HEIGHT));

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}