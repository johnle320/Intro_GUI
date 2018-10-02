package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Chpt14DefaultJFrame extends JFrame {

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private Container contentPane;
    private JButton cancelButton, okButton;

    Chpt14DefaultJFrame() {

        //set up the frame's properties:
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

        //create a button event listener, the class which we have to write
        ButtonHandler handler = new ButtonHandler();
        //add action listener:
        this.cancelButton.addActionListener(handler);
        this.okButton.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            //get the source of the event:
            JButton clickedButton = (JButton) evt.getSource();

            //get the text of the event source:
            String buttonText = clickedButton.getText();
            /* way 2:
            String buttonText = evt.getActionCommand();
             */

            //change the title of the frame accordingly
            setTitle("You clicked " + buttonText);

            /*
            //if the ButtonHandler is declared and implemented outside of the Chpt14defaultJFrame (instead being nested here)
            //then we have to get the frame that's is currently running. We obtain it through a root pane that contains
            //the event-source (the button that was clicked). Then change the title of that frame in accordance with the event

            JRootPane rootpane = clickedButton.getRootPane(); //get the root pane of the button
            Frame frame = (JFrame) rootpane.getParent(); //get the frame
            frame.setTitle("You clicked " + buttonText); //change the title of that frame in accordance with the event
             */
        }
    }

    private void changeBkColor(Color color) {
        this.contentPane.setBackground(color);
    }

}
