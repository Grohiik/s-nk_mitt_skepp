package view;

import main.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNorth  extends JPanel implements ActionListener {
    private Controller controller;
    private JButton btnNewGame;
    private JLabel counterLable;

    public PanelNorth(Controller controller) {
        this.controller = controller;
        createComponents();
    }

    private void createComponents(){
        btnNewGame = new JButton("new game");
        add(btnNewGame);

        counterLable = new JLabel("0");
        add(counterLable);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    public void increaseShotCounter() {
        counterLable.setText(String.valueOf(Integer.parseInt(counterLable.getText())+1));
    }
}
