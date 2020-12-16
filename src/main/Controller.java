package main;
import model.*;

public class Controller {
    public Controller(){
        Ship carrier = new carrier();
        System.out.println(carrier.getLength());
    }
}
