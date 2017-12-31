/* Lauren Sherman */

package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

public class ConnectFourFrame extends JFrame implements ActionListener { //This is where most of the game takes place
    private JButton[] colNum = new JButton[7]; //JButtons for each of the columns of the connect four board
    private JLabel[][] checkers = new JLabel[6][7]; //JLabels that create the grid of the board
    private JLabel promptLabel = new JLabel(); //promptLabel to ask where the players want to drop their checkers
    private String player1; //Player 1's name
    private String player2; //Player 2's name
    private int player1wins; //Counts the number of rounds player 1 has won
    private int player2wins; //Counts the number of rounds player 2 has won
    String currentPlayer = new String(); //Records who the current player is
    int playerNum = 0; //playerNum is 1 for player 1, then switches to 2 for player 2 (and back and forth again throughout the game)

    ConnectFourFrame(String x, String y, int xWins, int yWins) { //The parameters keep the names of player 1 and player 2 and the number of wins of player 1 and player 2 (in that order) updated in the frame
        player1 = x; //player1 is set to the first parameter of the constructor
        player2 = y; //player2 is set to the second parameter of the constructor
        player1wins = xWins; //player1wins is set to the third parameter (the first time ConnectFourFrame is called, this is initialized to 0 from NamesFrame)
        player2wins = yWins; //player2wins is set to the fourth parameter (the first time ConnectFourFrame is called, this too is initialized to 0 from NamesFrame)
        currentPlayer = player1; //Sets currentPlayer to start with player 1
        playerNum = 1; //Starts playerNum at 1 for player 1 (corresponds to currentPlayer - currentPlayer is the String name, playerNum is either 1 or 2)

        for (int i = 0; i <= 6; i++) { //Labels the column buttons
            colNum[i] = new JButton(new String(new Integer(i).toString()));
            colNum[i].addActionListener(this);
        }

        for (int i = 0; i <= 5; i++) { //Initializes all the places on the board to "EMPTY"
            for (int j = 0; j <= 6; j++) {

                checkers[i][j] = new JLabel(" EMPTY ");
                checkers[i][j].setFont(checkers[i][j].getFont().deriveFont(16.0f)); //Makes the font of the checkers bigger for better readability
            }
        }
        setLayout(new GridBagLayout());
        GridBagConstraints layoutConst = null;

        for (int i = 0; i <= 6; i++) { //Adds the column buttons
            layoutConst = new GridBagConstraints();
            layoutConst.insets = new Insets(5, 5, 5, 5);
            layoutConst.gridx = i;
            layoutConst.gridy = 0;
            add(colNum[i], layoutConst);
        }

        for (int j = 1; j <= 6; j++) { //Adds all the places on the board
            for (int i = 0; i <= 6; i++) {
                layoutConst = new GridBagConstraints();
                layoutConst.gridx = i;
                layoutConst.gridy = j;
                add(checkers[j - 1][i], layoutConst);
            }
        }

        promptLabel = new JLabel(currentPlayer + ", where would you like to drop your checker?"); //Asks into which column the current player would like to drop their checker

        layoutConst.gridx = 0;
        layoutConst.gridy = 7;
        layoutConst.insets = new Insets(50, 0, 0, 0);
        layoutConst.gridwidth = 6; //Makes the prompt label wide to avoid displacing the columns
        add(promptLabel, layoutConst); //Adds the prompt label to the frame

    }

    public boolean boardFull(){ //Checks if there are any empty (0) spaces in the board; otherwise no one can keep playing
        for (int i = 0; i < 6; ++i){
            for (int j = 0; j < 7; ++j){
                if (checkers[i][j].getText().equals(" EMPTY ")){
                    return false; //Returns false if the board is not full
                }
            }
        }
        return true; //returns true if the board is full
    }

    public int checkForWin(){ //Checks if one of the players has won
        int x = checkRows();
        int y = checkCols();
        int z = checkDiagR();
        int w = checkDiagL();
        if ((x == 1)||(y == 1)||(z == 1)||(w == 1)) {
            return 1; //returns 1 if player 1 has won
        }
        else if ((x == 2)||(y == 2)||(z == 2)||(w == 2)) {
            return 2; //returns 2 if player 2 has won
        }
        else if ((x == 0)||(y == 0)||(z == 0)||(w == 0)) {
            return 0; //returns 0 if no one has won
        }
        return 0;
    }
    public int checkRows(){ //Checks for four checkers next to each other in a row
        for (int i = 5; i >= 0; --i) {
            for (int j = 0; j <= 3; ++j) {
                if ((checkers[i][j].getText().equals(checkers[i][j+1].getText()))&&(checkers[i][j+1].getText().equals(checkers[i][j+2].getText()))&&(checkers[i][j+2].getText().equals(checkers[i][j+3].getText()))){
                    if (checkers[i][j].getText().equals("1")){
                        return 1; //If the four checkers are 1's, returns a 1 to represent player 1's win
                    }
                    else if (checkers[i][j].getText().equals("2")){
                        return 2; //If the four checkers are 2's, returns a 2 to represent player 2's win
                    }
                    else { //If there are four "EMPTY"'s in a row, that means nothing, so it returns 0
                        return 0;
                    }
                }
            }
        }
        return 0;
    }
    public int checkCols(){ //Checks for four checkers next to each other in a column, and returns values based on same criteria as checkRows
        for (int j = 0; j <= 6; ++j){
            for (int i = 2; i >= 0; --i){
                if ((checkers[i][j].getText().equals(checkers[i+1][j].getText()))&&(checkers[i+1][j].getText().equals(checkers[i+2][j].getText()))&&(checkers[i+2][j].getText().equals(checkers[i+3][j].getText()))){
                    if (checkers[i][j].getText().equals("1")){
                        return 1;
                    }
                    else if (checkers[i][j].getText().equals("2")){
                        return 2;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        return 0;
    }
    public int checkDiagR(){ //Checks for four checkers next to each other diagonally in one direction
        for (int i = 5; i >= 3; --i){
            for (int j = 0; j <= 3; ++j) {
                if ((checkers[i][j].getText().equals(checkers[i-1][j+1].getText()))&&(checkers[i-1][j+1].getText().equals(checkers[i-2][j+2].getText()))&&(checkers[i-2][j+2].getText().equals(checkers[i-3][j+3].getText()))){
                    if (checkers[i][j].getText().equals("1")){
                        return 1;
                    }
                    else if (checkers[i][j].getText().equals("2")){
                        return 2;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        return 0;
    }
    public int checkDiagL(){ //Checks for four checkers next to each other diagonally in the other direction
        for (int i = 5; i >= 3; --i){
            for (int j = 6; j >= 3; --j) {
                if ((checkers[i][j].getText().equals(checkers[i-1][j-1].getText()))&&(checkers[i-1][j-1].getText().equals(checkers[i-2][j-2].getText()))&&(checkers[i-2][j-2].getText().equals(checkers[i-3][j-3].getText()))){
                    if (checkers[i][j].getText().equals("1")){
                        return 1;
                    }
                    else if (checkers[i][j].getText().equals("2")){
                        return 2;
                    }
                    else {
                        return 0;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent event){

        for (int j = 0; j <= 6; ++j){ //Loops through each column the player can choose
            if(event.getSource() == colNum[j]){ //When it reaches which column matches the button the player clicked
                for (int i = 5; i >= 0; --i){ //Loops through the rows starting at the bottom
                    if (checkers[i][j].getText().equals(" EMPTY ")){ //Finds the first row that is empty
                        checkers[i][j].setText(Integer.toString(playerNum)); //Drops the checker into the position at that row and column (a 1 for player 1, and a 2 for player 2)
                        break; //Breaks from the loop so it does not keep dropping multiple checkers
                    }
                }
            }
        }
        if (playerNum == 1) { //If player 1 is current player, changes it to player 2
            currentPlayer = player2;
            playerNum = 2;
        }
        else if (playerNum == 2) { //If player 2 is current player, changes it to player 1
            currentPlayer = player1;
            playerNum = 1;
        }
        promptLabel.setText(currentPlayer + ", where would you like to drop your checker?"); //Resets the promptLabel so it changes for each player

        if (boardFull()){ //Announces that no one won the round if the board fills up without a win
            JOptionPane.showMessageDialog(this, "Sorry, no one won!");
            PlayAgainButtonFrame playAgain = new PlayAgainButtonFrame(player1, player2, player1wins, player2wins); //Calls the PlayAgainButtonFrame with player1, player2, player1wins, and player2wins as parameters
            playAgain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            playAgain.pack();
            playAgain.setVisible(true);
        }
        if (checkForWin() == 1){ //Announces that Player 1 won the round
            player1wins = player1wins + 1; //Increments player1wins
            JOptionPane.showMessageDialog(this, player1 + " wins! " + player1 + " has won " + player1wins + " rounds, and " + player2 + " has won " + player2wins + " rounds.");
            PlayAgainButtonFrame playAgain = new PlayAgainButtonFrame(player1, player2, player1wins, player2wins); //Calls the PlayAgainButtonFrame with player1, player2, player1wins, and player2wins as parameters
            playAgain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            playAgain.pack();
            playAgain.setVisible(true);
        }
        else if (checkForWin() == 2){ //Announces that Player 2 won the round
            player2wins = player2wins + 1; //increments player2wins
            JOptionPane.showMessageDialog(this, player2 + " wins! " + player1 + " has won " + player1wins + " rounds, and " + player2 + " has won " + player2wins + " rounds.");
            PlayAgainButtonFrame playAgain = new PlayAgainButtonFrame(player1, player2, player1wins, player2wins); //Calls the PlayAgainButtonFrame with player1, player2, player1wins, and player2wins as parameters
            playAgain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            playAgain.pack();
            playAgain.setVisible(true);
        }
    }
}
