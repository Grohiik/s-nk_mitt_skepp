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
    Gameboard gameboard;
    int size = 10;

    public Controller(){
        gameboard = new Gameboard(size);

        Ship carrier = new Carrier();
        System.out.println(carrier.getLength());
        mainFrame = new MainFrame(this, size);
    }

    public void shoot(int collum, int row){

    }
}