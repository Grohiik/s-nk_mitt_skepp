/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package controller;

import model.*;
import view.MainFrame;

/**
 * Controller used to call for gui functions, checks some actions that occurs when a user is playing the game
 */
public class Controller {
    MainFrame mainFrame;
    GameBoard gameboard;
    Scoreboard scoreboard;
    int shotCounter;
    int size = 10;


    /**
     * Constructor for the controller initiating the GUI and scoreboard
     */
    public Controller() {
        mainFrame = new MainFrame(this, size);
        scoreboard = new Scoreboard(100);
        newGameBoard();
    }

    /**
     * Confirms whether something was hit or not and what action should be executed
     * @param row Y coordinate
     * @param column X coordinate
     */
    public void shoot(int row, int column) {
        shotCounter++;
        TypesOfShots result = gameboard.shot(row, column);

        if (result == TypesOfShots.Hit) {
            mainFrame.hit(row, column);
        }
        else if (result == TypesOfShots.Dead) {
            mainFrame.hit(row, column);
            Ship ship = gameboard.getBoard()[row][column];
            mainFrame.errMessage("A " + ship.toString() + " has been destroyed", "Destroyed a ship");
            if (gameboard.hasWon()) {
                String name = mainFrame.inputWindow("You won, please enter your name");
                scoreboard.addPlayer(new Player(name, shotCounter));
                showScoreboard();
            }
        }
        else if (result == TypesOfShots.Miss) {
            mainFrame.miss(row, column);
        }
        else if (result == TypesOfShots.Error) {
            mainFrame.errMessage("What did you do?\nSend in a bug report with what you did pls.", "Error");
            shotCounter--;
        }
    }

    /**
     *  Creates a new gameboard
     */
    public void newGameBoard() {
        shotCounter = 0;
        mainFrame.reload();
        String choiceString = mainFrame.inputWindow("Which board would you like to use?");
        int choice;

        if (choiceString == null) {
            System.exit(0);
        }
        while (true) {
            try {
                choice = Integer.parseInt(choiceString);
                break;
            }
            catch (NumberFormatException e) {
                choiceString = mainFrame.inputWindow("Which board would you like to use?");
            }
        }
        gameboard = new GameBoard(size, choice);
    }

    /**
     * Shows the scoreboard
     */
    public void showScoreboard() {
        mainFrame.errMessage(scoreboard.showScoreboard(), "Scoreboard");
    }
}