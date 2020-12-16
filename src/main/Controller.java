package main;
import model.*;
import view.MainFrame;

public class Controller {
    MainFrame mainFrame;
    Gameboard gameboard;
    int size = 4;

    public Controller(){

        gameboard = new Gameboard(size);

        Ship carrier = new carrier();
        System.out.println(carrier.getLength());
        mainFrame = new MainFrame(this, size);
    }


    public void shoot(int collum, int row){

    }
}
