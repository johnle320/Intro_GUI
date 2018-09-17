package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
In this class, instead of defining our own listener, we can make the frame itself is-a listener.
 */
class Chpt14_FrameListener extends JFrame implements ActionListener{

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private Container contentPane;
    private JButton cancelButton, okButton;

    Chpt14_FrameListener() {
        //set up the window'd properties
        this.setTitle("My First Subclass");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        this.setResizable(false);

        //register 'Exit upon closing' as a default close operation
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //get the content pane
        this.contentPane = this.getContentPane(); //getContentPane returns JPane, which is a descendant of Container

        //set background color
        this.changeBkColor(Color.MAGENTA);

        //Create buttons:
        this.cancelButton = new JButton("CANCEL");
        this.okButton = new JButton("OK");

        //Create a Flow layout:
        FlowLayout layout1 = new FlowLayout();
        //Set that layout to the current panel:
        this.contentPane.setLayout(layout1);

        //set the buttons with the Flow layout
        this.contentPane.add(okButton);
        this.contentPane.add(cancelButton);

        //override the default size of the buttons:
        this.okButton.setSize(80, 30);
        this.cancelButton.setSize(80, 30);

        //add action listener:
        this.cancelButton.addActionListener(this);
        this.okButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        //get the source of the event:
        JButton clickedButton = (JButton) evt.getSource();

        //get the text of the event source:
        String buttontext = clickedButton.getText();
            /* way 2:
            String buttonText = evt.getActionCommand();
             */
        //because the frame is already the action listener, so we don't have to retrieve the frame that contains the
        //event source.
        this.setTitle("You clicked " + buttontext); //change the title of that frame in accordance with the event
    }

    private void changeBkColor(Color color) {
        this.contentPane.setBackground(color);
    }

}
