package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        /*
        //Frame with separately-created action listener
        JFrame default_JFrame;
        default_JFrame = new Chpt14DefaultJFrame();
        default_JFrame.setVisible(true);
         */

        /*
        //Frame is also the action listener itself
        JFrame listener_frame;
        listener_frame = new Chpt14_FrameListener();
        listener_frame.setVisible(true);
         */

        JFrame frame = new Chpt14_Frame1();
        frame.setVisible(true);


    }
}
