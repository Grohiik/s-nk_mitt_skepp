/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package view;
import main.Controller;

import javax.swing.*;

public class MainFrame {
    private JFrame frame;
    private MainPanel panel;

    private int width = 800;
    private int height = 500;

    public MainFrame(Controller controller, int size) {
        frame = new JFrame("Battleship!!!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(width, height);

        frame.setLocation(200, 200);
        //frame.setResizable(true);
        panel = new MainPanel(controller, size);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void errMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}