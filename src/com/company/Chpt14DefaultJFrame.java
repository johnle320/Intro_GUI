package com.company;
import javax.swing.*;
import java.awt.*;

class Chpt14DefaultJFrame extends JFrame {

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private Container contentPane;
    private JButton cancelButton, okButton;

    Chpt14DefaultJFrame() {
        //set up the window'd properties
        this.setTitle("My First Subclass");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);

        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //get the content pane
        contentPane = this.getContentPane(); //getContentPane returns JPane, which is a descendant of Container

        //set background color
        this.changeBkColor(Color.MAGENTA);

        cancelButton = new JButton("CANCEL");
        okButton = new JButton("OK");

        //Create a Flow layout:
        FlowLayout layout1 = new FlowLayout();
        //Set that layout to the current panel:
        contentPane.setLayout(layout1);

        //set the buttons with the Flow layout
        contentPane.add(okButton);
        contentPane.add(cancelButton);

        //override the default size of the buttons:
        okButton.setSize(80, 30);
        cancelButton.setSize(80, 30);
    }

    private void changeBkColor(Color color) {
        contentPane.setBackground(color);
    }
}
