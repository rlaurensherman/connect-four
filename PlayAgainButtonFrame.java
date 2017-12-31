/* Lauren Sherman */

package com.company;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayAgainButtonFrame extends JFrame implements ActionListener { //Creates a frame asking if the players want to play again
    private JLabel askLabel; //JLabel to ask if players want to play again
    private JButton playButton; //JButton if players want to play again
    private JButton quitButton; //JButton if players want to quit
    String p1; //Stores player 1's name
    String p2; //Stores player 2's name
    int p1Wins; //Stores player 1's wins
    int p2Wins; //Stores player 2's wins

    PlayAgainButtonFrame(String a, String b, int aWins, int bWins) {
        p1 = a; //Sets p1 to the first parameter that has player 1's name
        p2 = b; //Sets p2 to the second parameter that has player 2's name
        p1Wins = aWins; //Sets p1wins to the third parameter that has player 1's wins
        p2Wins = bWins; //Sets p2wins to the fourth parameter that has player 2's wins

        GridBagConstraints positionConst = null;

        setTitle("Play Again"); //Sets title of frame to "Play Again"

        askLabel = new JLabel("Would you like to play again?"); //Sets JLabel to ask if players want to play again

        playButton = new JButton("Play"); //Sets play button to say "Play"
        playButton.addActionListener(this);
        quitButton = new JButton("Quit"); //Sets quit button to say "Quit"
        quitButton.addActionListener(this);

        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();

        positionConst.gridx = 0;
        positionConst.gridy = 0;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(askLabel, positionConst); //Adds askLabel at position (0, 0)

        positionConst.gridx = 0;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(playButton, positionConst); //Adds playButton at position (0, 1)

        positionConst.gridx = 0;
        positionConst.gridy = 2;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(quitButton, positionConst); //Adds quitButton at position (0, 2)
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == playButton){ //If players click the play button
            ConnectFourFrame myFrame = new ConnectFourFrame(p1, p2, p1Wins, p2Wins); //Calls ConnectFourFrame with names and number of wins in parameters
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.pack();
            myFrame.setVisible(true);
        }
        else if (event.getSource() == quitButton){ //If players click the quit button
            if (p1Wins > p2Wins) {
                JOptionPane.showMessageDialog(this, p1 + " wins!"); //Announces that player 1 won more rounds
            }
            else if (p2Wins > p1Wins) {
                JOptionPane.showMessageDialog(this, p2 + " wins!"); //Announces that player 2 won more rounds
            }
            else if (p1Wins == p2Wins) {
                JOptionPane.showMessageDialog(this, "You have tied!"); //Announces that the won the same amount of rounds
            }
        }

        return;
    }
}
