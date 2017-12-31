/* Lauren Sherman */

package com.company;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NamesFrame extends JFrame implements ActionListener { //The NamesFrame opens a new frame to get the players' names
    private JLabel player1label; //The JLabel that asks for player 1's name
    private JLabel player2label; //The JLabel that asks for player 2's name
    private JTextField player1Field; //The JTextField where the user puts player 1's name
    private JTextField player2Field; //The JTextField where the user puts player 2's name
    private JButton continueButton; //The JButton to continue to the game once the names are typed in

    NamesFrame() {

        GridBagConstraints positionConst = null;

        setTitle("Names"); //Sets frame's title to "Names"

        player1label = new JLabel("Player 1 name:"); //Asks for player 1's name
        player2label = new JLabel("Player 2 name:"); //Asks for player 2's name

        player1Field = new JTextField(15); //Creates JTextField for player 1's name
        player1Field.setEditable(true); //Makes it editable by the user
        player1Field.setText("");

        player2Field = new JTextField(15); //Creates JTextField for player 2's name
        player2Field.setEditable(true); //Makes it editable by the user
        player2Field.setText("");

        continueButton = new JButton("Continue"); //Creates a "Continue" button for when the players' names are typed in

        continueButton.addActionListener(this);

        setLayout(new GridBagLayout());
        positionConst = new GridBagConstraints();

        positionConst.gridx = 0;
        positionConst.gridy = 0;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(player1label, positionConst); //Adds player1label at position (0, 0)

        positionConst.gridx = 1;
        positionConst.gridy = 0;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(player1Field, positionConst); //Adds player1Field at position (1, 0)

        positionConst.gridx = 0;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(player2label, positionConst); //Adds player2label at position (0, 1)

        positionConst.gridx = 1;
        positionConst.gridy = 1;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(player2Field, positionConst); //Adds player2Field at position (1, 1)

        positionConst.gridx = 0;
        positionConst.gridy = 2;
        positionConst.insets = new Insets(10, 10, 10, 10);
        add(continueButton, positionConst); //Adds continueButton at position (0, 2)

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String user1Input = ""; //Represents player 1's name
        String user2Input = ""; //Represents player 2's name
        user1Input = player1Field.getText(); //Retrieves the text typed in for player 1's name and puts it in user1Input
        user2Input = player2Field.getText(); //Retrieves the text typed in for player 2's name and puts it in user2Input

        ConnectFourFrame myFrame = new ConnectFourFrame(user1Input, user2Input, 0, 0); //Calls ConnectFourFrame, where game takes place, with the players' names and 0's as parameters. (Further explained in ConnectFourFrame)
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);

        return;
    }



}
