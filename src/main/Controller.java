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
            mainFrame.errMessage("A "+ship.toString()+" is dead");
            if(gameboard.hasWon()){
                String name = mainFrame.inputWindow("you won: enter name");
                scoreboard.addPlayer(new Player(name, shotCounter));
                showScoreboard();
            }
        }else if(result == TypesOfShots.Miss){
            mainFrame.miss(collum, row);
        }else if(result == TypesOfShots.Error){
            mainFrame.errMessage("what did you do?\nSend in a bug report with what you did pls.");
            shotCounter--;
        }
    }

    public void newGameBoard(){
        shotCounter = 0;
        mainFrame.reload();
        String choiceString = mainFrame.inputWindow("what gameBoard do you want?");
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
                choiceString = mainFrame.inputWindow("what gameBoard do you want?");
            }
        }
        gameboard = new GameBoard(size, choice);
    }

    public void showScoreboard(){
        mainFrame.errMessage(scoreboard.showScoreboard());
    }
}