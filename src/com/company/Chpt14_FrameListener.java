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
    private JTextField inputLine;
    private JButton cancelButton, okButton;

    Chpt14_FrameListener() {
        //set up the window'd properties
        this.setTitle("My First Subclass");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        this.setResizable(true);

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

        //override the default size of the buttons:
        this.okButton.setSize(80, 30);
        this.cancelButton.setSize(80, 30);

        //set up text field:
        this.inputLine = new JTextField();
        this.inputLine.setColumns(20);
        this.inputLine.setFont(new Font("Courier", Font.PLAIN, 14));

        //stage GUI objects:
            /*
            //We can add those GUI objects into JFrame
            this.add(okButton);
            this.add(inputLine);
            this.add(inputLine)
             */

        //but one thing is that JFrame cannot be added to anything else once we want it to. So it is always better to
        //add GUI objects to a container:
        this.contentPane.add(okButton);
        this.contentPane.add(cancelButton);
        this.contentPane.add(inputLine);


        //add action listener:
        this.cancelButton.addActionListener(this);
        this.okButton.addActionListener(this);
        this.inputLine.addActionListener(this);
        /*
        As we can see this approach of using 1 handler (Chpt14_FrameListener instance) is problematic, since in the
        actionPerformed() we would have to do a bunch of if-else statement to determine which event source is sending
        the action event.
         */

    }

    public void actionPerformed(ActionEvent evt) {
        //get the source of the event:
        Object evtSrc = evt.getSource(); //getSource() returns Object type

        //determine the event source
        if (evtSrc instanceof JButton) {
            //get the text of the event source:
            String buttontext = ((JButton) evtSrc).getText();
                /* way 2:
                String buttonText = evt.getActionCommand();
                 */

            //because the frame is already the action listener, so we don't have to retrieve the frame that contains the
            //event source.
            this.setTitle("You clicked " + buttontext); //change the title of that frame in accordance with the event
        } else {
            this.setTitle("You Entered: " + this.inputLine.getText());
        }
    }

    private void changeBkColor(Color color) {
        this.contentPane.setBackground(color);
    }

}
