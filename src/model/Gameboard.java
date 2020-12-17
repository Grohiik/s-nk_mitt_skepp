package model;

public class Gameboard {
    private Ship[][] board;
    public Gameboard(int size){
        board = new Ship[size][size];
        submarine sub = new submarine();
        carrier carrier = new carrier();
        board[0][0] = sub;

        board[1][0] = carrier;
        board[1][1] = carrier;
        board[1][2] = carrier;
        board[1][3] = carrier;
        board[1][4] = carrier;
    }

    public Ship[][] getBoard(){
        return board;
    }
    public TypesOfShots shot(int collum, int row){
        if(collum > board.length || row > board[0].length || collum<0||row<0){
            return TypesOfShots.Error;
        }
        Ship ship = board[collum][row];
        if(ship != null){
            ship.incHits();
            if(ship.isDead()){
                return TypesOfShots.Dead;
            }
            return TypesOfShots.Hit;
        }
        return TypesOfShots.Miss;
    }

    public boolean hasWon(){
        for (Ship[] ships: board){
            for (Ship ship: ships){
                if(ship == null){
                    continue;
                }
                if(!ship.isDead()){
                    return false;
                }
            }
        }
        return true;
    }
}
