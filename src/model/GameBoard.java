/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package model;

// Creates the board the game is played on, will create an array the ships are placed on, the remaining spots in the array are seen as null (empty spaces)
public class GameBoard {
    Ship[][] board;

    public GameBoard(int size, int choice) {
        board = new Ship[size][size];

        if (choice == 1)
        {
            gameBoardV1();
        }
        else
        {
            gameBoardV2();
        }
    }

    /**
     * Version 1 of the game board, ship placement in a 10 times 10 grid
     */
    private void gameBoardV1() {
        Submarine placedSubmarine = new Submarine();
        Carrier placedCarrier = new Carrier();
        Battleship placedBattleship = new Battleship();
        Destroyer placedDestroyer = new Destroyer();
        Torpedo placedTorpedo = new Torpedo();

        //Battleship placement
        board[3][0] = placedBattleship;
        board[4][0] = placedBattleship;
        board[5][0] = placedBattleship;
        board[6][0] = placedBattleship;

        //Submarine placement
        board[1][6] = placedSubmarine;

        //Torpedo placement
        board[5][8] = placedTorpedo;
        board[5][9] = placedTorpedo;

        //Destroyer placement
        board[9][5] = placedDestroyer;
        board[9][6] = placedDestroyer;
        board[9][7] = placedDestroyer;

        //Carrier placement
        board[6][2] = placedCarrier;
        board[6][3] = placedCarrier;
        board[6][4] = placedCarrier;
        board[6][5] = placedCarrier;
        board[6][6] = placedCarrier;
    }

    /**
     * Version 2 of the game board, ship placement in a 10 times 10 grid
     */
    private void gameBoardV2() {
        Submarine placedSubmarine = new Submarine();
        Carrier placedCarrier = new Carrier();
        Battleship placedBattleship = new Battleship();
        Destroyer placedDestroyer = new Destroyer();
        Torpedo placedTorpedo = new Torpedo();

        //Battleship placement
        board[0][2] = placedBattleship;
        board[0][3] = placedBattleship;
        board[0][4] = placedBattleship;
        board[0][5] = placedBattleship;

        //Submarine placement
        board[1][6] = placedSubmarine;

        //Torpedo placement
        board[4][3] = placedTorpedo;
        board[3][3] = placedTorpedo;

        //Destroyer placement
        board[5][9] = placedDestroyer;
        board[6][9] = placedDestroyer;
        board[7][9] = placedDestroyer;

        //Carrier placement
        board[2][1] = placedCarrier;
        board[2][2] = placedCarrier;
        board[2][3] = placedCarrier;
        board[2][4] = placedCarrier;
        board[2][5] = placedCarrier;
    }

    /**
     * Checks what type of shot was made, did it hit, miss or kill
     * @param row Y coordinate
     * @param column X coordinate
     * @return the type of shot made
     */
    public TypesOfShots shot(int row, int column) {
        if (row > board.length || column > board[0].length || row<0||column<0) {
            return TypesOfShots.Error;
        }
        Ship ship = board[row][column];
        if (ship != null) {
            ship.incHits();
            if (ship.isDead()) {
                return TypesOfShots.Dead;
            }
            return TypesOfShots.Hit;
        }
        return TypesOfShots.Miss;
    }

    /**
     * Checks if all enemies has been destroyed
     * @return won or not
     */
    public boolean hasWon() {
        for (Ship[] ships: board) {
            for (Ship ship: ships) {
                if (ship == null) {
                    continue;
                }
                if (!ship.isDead()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Ship[][] getBoard() {
        return board;
    }
}