package model;

public class Gameboard {
    Ship[][] board;
    public Gameboard(int size){
        board = new Ship[size][size];
    }

    public Ship[][] getBoard(){
        return board;
    }
}
