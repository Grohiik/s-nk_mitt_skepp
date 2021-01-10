/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package view;
import controller.Controller;

import javax.swing.*;

public class MainFrame {
    private JFrame frame;
    private MainPanel panel;
    Controller controller;
    int size;

    private int width = 800;
    private int height = 500;

    public MainFrame(Controller controller, int size) {
        this.controller = controller;
        this.size = size;

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

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

    public void errMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void hit(int column, int row) {
        panel.hit(column, row);
    }

    public void miss(int column, int row) {
        panel.miss(column, row);
    }

    public String inputWindow(String msg){
        return JOptionPane.showInputDialog(frame, msg);
    }

    public void reload() {
        panel.reload();
    }
}