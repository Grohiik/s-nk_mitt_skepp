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

    public PanelNorth(Controller controller) {
        this.controller = controller;
        createComponents();
    }

    private void createComponents(){
        btnNewGame = new JButton("new game");
        add(btnNewGame);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}