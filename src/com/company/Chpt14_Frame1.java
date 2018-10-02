package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/*
In Chpt14_FrameListener, we have:
        this.cancelButton.addActionListener(this);
        this.okButton.addActionListener(this);
        this.inputLine.addActionListener(this);

        //As we can see this approach of using 1 handler (Chpt14_FrameListener instance) is problematic, since in the
        //actionPerformed() we would have to do a bunch of if-else statement to determine which event source is sending
        //the action event and, therefore, act on that accordingly.


        //so in this class, we would create separate handler for each source. One for the Ok button, one for the cancel button,
        //and the other for the textfield input. Chpt14_Frame is no longer implementing ActionListener

 */
class Chpt14_Frame1 extends JFrame{

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 200;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private Container contentPane;
    private JTextField inputLine;
    private JButton cancelButton, okButton;


    private ImageIcon imageIcon;
    private JLabel imageLabel;
    private JLabel inputLineLabel;

    Chpt14_Frame1() throws IOException {
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

        //override the default size of the buttons:
        this.okButton.setSize(80, 30);
        this.cancelButton.setSize(80, 30);

        //set up text field:
        this.inputLine = new JTextField();
        this.inputLine.setColumns(20);
        this.inputLine.setFont(new Font("Courier", Font.PLAIN, 14));


        //Load the image


        //way 1:
//        this.imageIcon = createImageIcon1("/resources/images/java.png", "my lovely wife says: ");
        //way 2:
        this.imageIcon = createImageIcon2("/resources/images/nhi.JPG", "my lovely wife says: ");

        this.imageLabel = new JLabel(imageIcon);
        this.imageLabel.setSize(100, 100); //not sure if it matters
        this.contentPane.add(imageLabel);



        //create a label for the text field:
        this.inputLineLabel = new JLabel();
        this.inputLineLabel.setText("Please enter your text here");
        this.inputLineLabel.setSize(50, 150);


        //stage GUI objects:
            /*
            //We can add those GUI objects into JFrame
            this.add(okButton);
            this.add(inputLine);
            this.add(inputLine)
             */

        //but one thing is that JFrame cannot be added to anything else once we want it to. So it is always better to
        //add GUI objects to a container:

        this.contentPane.add(inputLineLabel);
        this.contentPane.add(inputLine);
        this.contentPane.add(okButton);
        this.contentPane.add(cancelButton);


        //create action listener by using anonymous inner class:

        /*
            //It makes more sense to name event-listeners to the name of the JOB THEY ARE listening to, rather than to the
            //type of the event-source, because for a set of similar components that do the same type of job, one event-handler
            //can be associated with those.
         */


        //register Listeners to the event-sources
        okButton.addActionListener(evt -> {
            JButton clickedButton = (JButton) evt.getSource();
            String text = clickedButton.getText();
            setTitle("You clicked: " + text);
        });

        cancelButton.addActionListener(evt -> {
            JButton clickedButton = (JButton) evt.getSource();
            String text = clickedButton.getText();
            setTitle("You clicked: " + text);
        });

        inputLine.addActionListener(evt -> {
            JTextField textEntered = (JTextField) evt.getSource();
            String text = textEntered.getText();
            setTitle("You entered: " + text);
        });

    }

    /** Returns an ImageIcon, or throw an IOException if the path was invalid */
    private ImageIcon createImageIcon2(String relativePath, String description) throws IOException {
        Image img;
        try {
            img = ImageIO.read(this.getClass().getResource(relativePath));
            img = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            return  new ImageIcon(img, description);
        } catch (IOException e) {
            throw new IOException("Couldn't find file: " + relativePath);
        }
    }

    /** Author: ORACLE
     * Returns an ImageIcon, or null if the path was invalid. */
    private ImageIcon createImageIcon1(String relativePath,
                                        String description) throws IOException {
        java.net.URL imgURL = getClass().getResource(relativePath);
        if (imgURL == null) {
            throw new IOException("Couldn't find file: " + relativePath);
        }

        //ImageIcon only takes absolute path
        return new ImageIcon(imgURL, description); //image would not be scaled
    }

    private void changeBkColor(Color color) {
        this.contentPane.setBackground(color);
    }

    /*
    //Instead of using anounymous inner class for event_listeners, we can us private nest class:

    private class OkButtonHanddler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        }
    }

    private class CancelButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        }
    }

    private class TextInputHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        }
    }
     */

}
