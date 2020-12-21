/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package view;

import main.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNorth  extends JPanel implements ActionListener {
    private Controller controller;
    private JButton btnNewGame;
    private JButton btnScoreBoard;
    private JLabel counterLable;
    private JLabel counter;

    public PanelNorth(Controller controller) {
        this.controller = controller;
        createComponents();
    }

    private void createComponents(){
        btnNewGame = new JButton(Buttons.New_game.getName());
        add(btnNewGame);
        btnNewGame.addActionListener(this);

        btnScoreBoard = new JButton(Buttons.ScoreBoard.getName());
        add(btnScoreBoard);
        btnScoreBoard.addActionListener(this);

        counter = new JLabel("Shots fired:");
        add(counter);

        counterLable = new JLabel("0");
        add(counterLable);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(Buttons.New_game.getName())){
            controller.newGameBoard();
        } else if (e.getActionCommand().equals(Buttons.ScoreBoard.getName()));{
            controller.showScoreboard();
        }
    }

    public void increaseShotCounter() {
        counterLable.setText(String.valueOf(Integer.parseInt(counterLable.getText())+1));
    }

    public void reset() {
        counterLable.setText("0");
    }
}