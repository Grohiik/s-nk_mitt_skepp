/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package main;

import model.*;
import view.MainFrame;

public class Controller {
    MainFrame mainFrame;
    GameBoard gameboard;
    Scoreboard scoreboard;
    int shotCounter;
    int size = 10;

    public Controller(){
        mainFrame = new MainFrame(this, size);
        scoreboard = new Scoreboard(100);
        newGameBoard();
    }

    public void shoot(int collum, int row){
        shotCounter++;
        TypesOfShots result = gameboard.shot(collum, row);
        if(result == TypesOfShots.Hit){
            mainFrame.hit(collum, row);
        }else if(result == TypesOfShots.Dead){
            mainFrame.hit(collum, row);
            Ship ship = gameboard.getBoard()[collum][row];
            mainFrame.errMessage("A "+ship.toString()+" has been destroyed");
            if(gameboard.hasWon()){
                String name = mainFrame.inputWindow("You won, enter your name name");
                scoreboard.addPlayer(new Player(name, shotCounter));
                showScoreboard();
            }
        }else if(result == TypesOfShots.Miss){
            mainFrame.miss(collum, row);
        }else if(result == TypesOfShots.Error){
            mainFrame.errMessage("What did you do?\nSend in a bug report with what you did pls.");
            shotCounter--;
        }
    }

    public void newGameBoard(){
        shotCounter = 0;
        mainFrame.reload();
        String choiceString = mainFrame.inputWindow("Which board would you like to use?");
        int choice;
        if (choiceString == null){
            System.exit(0);
        }
        while (true){
            try{
                choice = Integer.parseInt(choiceString);
                break;
            }
            catch (NumberFormatException e){
                choiceString = mainFrame.inputWindow("Which board would you like to use?");
            }
        }
        gameboard = new GameBoard(size, choice);
    }

    public void showScoreboard(){
        mainFrame.errMessage(scoreboard.showScoreboard());
    }
}