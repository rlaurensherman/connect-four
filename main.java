/* Lauren Sherman */

package com.company;

import javax.swing.*;

public class Main { //This is the Main class. Most things happen through the GUI classes.

    public static void main(String[] args) {

        PlayButtonFrame playFrame = new PlayButtonFrame(); //This calls PlayButtonFrame
        playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets PlayButtonFrame to exit on close
        playFrame.pack(); //Sets frame to fit what it contains
        playFrame.setVisible(true); //Sets frame visible

    }
}
