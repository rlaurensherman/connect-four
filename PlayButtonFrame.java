/* Lauren Sherman */

package com.company;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlayButtonFrame extends JFrame implements ActionListener { //The PlayButtonFrame will open a new frame where the players will choose to play the game
    private JLabel askLabel; //JLabel for asking if they want to play
    private JButton playButton; //JButton for playing the game

    PlayButtonFrame() {

        GridBagConstraints positionConst = null; //Initializes GridBagConstraints

        setTitle("Play Game"); //Makes the title of the frame "Play Game"

        askLabel = new JLabel("This is a game of connect four! Try to get four of your checkers next to each other on the board. Would you like to play?"); //Gives instructions and asks if players want to play

        playButton = new JButton("Play!"); //Creates a "Play!" button for the players to click to play the game

        playButton.addActionListener(this); //Adds action listener to play button

        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();

        positionConst.gridx = 0;
        positionConst.gridy = 0;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(askLabel, positionConst); //Puts the askLabel in position (0, 0) in the frame

        positionConst.gridx = 0;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(playButton, positionConst); //Puts the playButton in position (0, 1) in the frame
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        NamesFrame newFrame = new NamesFrame(); //Calls NamesFrame when the play button is pressed
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.pack();
        newFrame.setVisible(true);

        return;
    }
}
