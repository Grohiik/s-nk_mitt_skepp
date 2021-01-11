/*
  Author: Marcus Linné, Linnéa Mörk
  Id: ai8851, al2804
  Study program: DT
*/

package view;

public enum Buttons {
    New_game("New Game"),
    ScoreBoard("View Scoreboard");

    private String name;

    private Buttons(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}