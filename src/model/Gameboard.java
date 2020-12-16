/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package model;

//Creates the board the game is played on,will create an array the ships are placed on, the remaining spots in the array are seen as null (empty spaces)
public class Gameboard {
    Ship[][] board;
    public Gameboard(int size){
        board = new Ship[size][size];
    }
}