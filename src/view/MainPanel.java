/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class MainPanel extends JPanel {
    private int size;
    private PanelCenter pnlCenter;
    private PanelNorth pnlNorth;

    private Controller controller;

    public MainPanel(Controller controller, int size) {
        this.size = size;
        this.controller = controller;

        setupPanel();
    }

    private void setupPanel() {
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        Border border = this.getBorder();
        //Let the panel have a border, 10 pixels on all sides
        Border margin = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(new CompoundBorder(border, margin));

        // on the northern part of the MainPanel
        pnlNorth = new PanelNorth (controller);
        add(pnlNorth, BorderLayout.NORTH);

        //list at center of gui
        pnlCenter = new PanelCenter (controller, size);
        add(pnlCenter, BorderLayout.CENTER);
    }

    public void hit(int collum, int row) {
        pnlCenter.hit(collum, row);
        pnlNorth.increaseShotCounter();
    }

    public void miss(int collum, int row) {
        pnlCenter.miss(collum, row);
        pnlNorth.increaseShotCounter();
    }

    public void reload() {
        pnlNorth.reset();
        pnlCenter.reset();
    }
}