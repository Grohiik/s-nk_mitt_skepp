/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package view;

import main.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCenter  extends JPanel implements ActionListener {
    private Controller controller;
    private int size;
    private JButton[][] buttons;

    public PanelCenter(Controller controller, int size) {
        this.controller = controller;
        this.size = size;
        buttons = new JButton[size][size];
        createComponents();
    }

    private void createComponents(){
        GridLayout layout = new GridLayout(size, size);
        setLayout(layout);
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                buttons[i][j] = new JButton(" ");
                add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                if (buttons[i][j].equals(button)){
                    controller.shoot(i, j);
                    break;
                }
            }
        }
    }


    public void hit(int collum, int row) {
        JButton button = buttons[collum][row];
        button.setText("!");
        button.setEnabled(false);
    }

    public void miss(int collum, int row) {
        JButton button = buttons[collum][row];
        button.setText("X");
        button.setEnabled(false);
    }
}