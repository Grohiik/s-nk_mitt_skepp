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
    int shotCounter = 0;
    int size = 10;
    int choice;
    public Controller(){
        gameboard = new GameBoard(size, choice);
        scoreboard = new Scoreboard(100);
        mainFrame = new MainFrame(this, size);
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
                mainFrame.errMessage(scoreboard.showScoreboard());
            }
        }else if(result == TypesOfShots.Miss){
            mainFrame.miss(collum, row);
        }else if(result == TypesOfShots.Error){
            mainFrame.errMessage("what did you do?\nSend in a bug report with what you did pls.");
            shotCounter--;
        }
    }
}